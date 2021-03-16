/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Exceptions.NoPatientsToBeScheduled;
import Model.Exceptions.NoRegisteredPatientsException;
import Model.Exceptions.PrioritiesAlreadyAssignedException;
import Model.PQGroup;
import Model.Patient;
import Model.VaccinationListManager;
import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maximiliano Herrera
 */
public class VaccinationListManagerTests {

    public VaccinationListManagerTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void when_adding_people_to_the_list_count_and_list_return_the_expected_values() {
        VaccinationListManager listManager = new VaccinationListManager();
        Patient p1 = new Patient("name1", 45, false);

        assertThat(0, is(listManager.size()));
        assertThat(0, is(listManager.getAllRegisteredPatients().size()));

        listManager.addPatient(p1);
        assertThat(1, is(listManager.size()));
        assertThat(1, is(listManager.getAllRegisteredPatients().size()));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p1)).findFirst().orElse(null));

        Patient p2 = new Patient("name2", 32, false);
        listManager.addPatient(p2);
        assertThat(2, is(listManager.size()));
        assertThat(2, is(listManager.getAllRegisteredPatients().size()));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p1)).findFirst().orElse(null));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p2)).findFirst().orElse(null));
    }

    @Test
    public void when_identifying_next_group_of_people_they_are_removed_from_the_list() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException, NoPatientsToBeScheduled {
        VaccinationListManager listManager = new VaccinationListManager();
        Patient p4 = new Patient("priority 4", 45, false);
        Patient p3 = new Patient("priority 3", 32, false);

        listManager.addPatient(p3);
        listManager.addPatient(p4);

        assertThat(2, is(listManager.size()));
        assertThat(2, is(listManager.getAllRegisteredPatients().size()));

        listManager.setPriorities();

        PQGroup nextGroup = listManager.getNextGroupToBeScheduled();
        assertThat(1, is(nextGroup.size()));
        assertThat(1, is(listManager.size()));
        assertThat(1, is(listManager.getAllRegisteredPatients().size()));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p3)).findFirst().orElse(null));
        assertNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p4)).findFirst().orElse(null));
        assertNotNull(nextGroup.getPatients().stream().filter(x -> x.equals(p4)).findFirst().orElse(null));

        nextGroup = listManager.getNextGroupToBeScheduled();
        assertThat(1, is(nextGroup.size()));
        assertNotNull(nextGroup.getPatients().stream().filter(x -> x.equals(p3)).findFirst().orElse(null));
        assertThat(0, is(listManager.size()));
        assertThat(0, is(listManager.getAllRegisteredPatients().size()));
    }

    @Test
    public void When_removing_next_group_it_is_the_expected() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException, NoPatientsToBeScheduled {
        ArrayList<Patient> list = new ArrayList<>();
        VaccinationListManager listManager = new VaccinationListManager();
        //- Priority 10: People aged 90 and older        
        Patient p1 = new Patient("name1", 90, false);
        Patient p2 = new Patient("name2", 95, false);
        Patient p3 = new Patient("name3", 100, false);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        ArrayList<Patient> priority10 = new ArrayList<>();
        priority10.add(p1);
        priority10.add(p2);
        priority10.add(p3);

        //- Priority 9: People aged 80 and older 
        Patient p4 = new Patient("name1", 80, false);
        Patient p5 = new Patient("name2", 82, false);
        Patient p6 = new Patient("name3", 89, false);

        list.add(p4);
        list.add(p5);
        list.add(p6);

        ArrayList<Patient> priority9 = new ArrayList<>();
        priority9.add(p4);
        priority9.add(p5);
        priority9.add(p6);

        //- Priority 8: People aged 70 and older 
        Patient p7 = new Patient("name7", 70, false);
        Patient p8 = new Patient("name8", 74, false);
        Patient p9 = new Patient("name9", 79, false);

        list.add(p7);
        list.add(p8);
        list.add(p9);

        ArrayList<Patient> priority8 = new ArrayList<>();
        priority8.add(p7);
        priority8.add(p8);
        priority8.add(p9);

        //- Priority 7: People aged 65-69 
        Patient p10 = new Patient("name10", 65, false);
        Patient p11 = new Patient("name11", 67, false);
        Patient p12 = new Patient("name12", 69, false);

        list.add(p10);
        list.add(p11);
        list.add(p12);

        ArrayList<Patient> priority7 = new ArrayList<>();
        priority7.add(p10);
        priority7.add(p11);
        priority7.add(p12);

        //- Priority 6: People aged 18-64 with medical condition(s) 
        Patient p13 = new Patient("name13", 18, true);
        Patient p14 = new Patient("name14", 50, true);
        Patient p15 = new Patient("name15", 64, true);

        list.add(p13);
        list.add(p14);
        list.add(p15);

        ArrayList<Patient> priority6 = new ArrayList<>();
        priority6.add(p13);
        priority6.add(p14);
        priority6.add(p15);

        //- Priority 5: People aged 55-64 
        Patient p16 = new Patient("name16", 55, false);
        Patient p17 = new Patient("name17", 58, false);
        Patient p18 = new Patient("name18", 64, false);

        list.add(p16);
        list.add(p17);
        list.add(p18);

        ArrayList<Patient> priority5 = new ArrayList<>();
        priority5.add(p16);
        priority5.add(p17);
        priority5.add(p18);

        //- Priority 4: People aged 45-54 
        Patient p19 = new Patient("name19", 45, false);
        Patient p20 = new Patient("name20", 50, false);
        Patient p21 = new Patient("name21", 54, false);

        list.add(p19);
        list.add(p20);
        list.add(p21);

        ArrayList<Patient> priority4 = new ArrayList<>();
        priority4.add(p19);
        priority4.add(p20);
        priority4.add(p21);

        //- Priority 3: People aged 30-44 
        Patient p22 = new Patient("name22", 30, false);
        Patient p23 = new Patient("name23", 40, false);
        Patient p24 = new Patient("name24", 44, false);

        list.add(p22);
        list.add(p23);
        list.add(p24);

        ArrayList<Patient> priority3 = new ArrayList<>();
        priority3.add(p22);
        priority3.add(p23);
        priority3.add(p24);

        //- Priority 2: people aged 18-29 
        Patient p25 = new Patient("name25", 18, false);
        Patient p26 = new Patient("name26", 25, false);
        Patient p27 = new Patient("name27", 29, false);

        list.add(p25);
        list.add(p26);
        list.add(p27);

        ArrayList<Patient> priority2 = new ArrayList<>();
        priority2.add(p25);
        priority2.add(p26);
        priority2.add(p27);

        //- Priority 1: People aged under 18
        Patient p28 = new Patient("name28", 5, false);
        Patient p29 = new Patient("name29", 10, false);
        Patient p30 = new Patient("name30", 17, false);

        list.add(p28);
        list.add(p29);
        list.add(p30);

        ArrayList<Patient> priority1 = new ArrayList<>();
        priority1.add(p28);
        priority1.add(p29);
        priority1.add(p30);

        Collections.shuffle(list);

        list.forEach((patient) -> {
            listManager.addPatient(patient);
        });

        listManager.setPriorities();

        PQGroup nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority10, 10);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority9, 9);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority8, 8);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority7, 7);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority6, 6);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority5, 5);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority4, 4);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority3, 3);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority2, 2);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority1, 1);
    }

    @Test(expected = NoPatientsToBeScheduled.class)
    public void When_removing_next_group_from_empty_list_an_exception_is_thrown() throws NoPatientsToBeScheduled {
        VaccinationListManager listManager = new VaccinationListManager();

        listManager.getNextGroupToBeScheduled();
    }

    @Test(expected = NoPatientsToBeScheduled.class)
    public void When_removing_next_group_from_a_list_without_assigned_priorities_an_exception_is_thrown() throws NoPatientsToBeScheduled {
        VaccinationListManager listManager = new VaccinationListManager();
        Patient p4 = new Patient("priority 4", 45, false);
        Patient p3 = new Patient("priority 3", 32, false);

        listManager.addPatient(p3);
        listManager.addPatient(p4);

        listManager.getNextGroupToBeScheduled();
    }

    @Test(expected = NoRegisteredPatientsException.class)
    public void When_setting_priorities_to_an_empty_list_an_exception_is_thrown() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException {
        VaccinationListManager listManager = new VaccinationListManager();

        listManager.setPriorities();
    }

    @Test(expected = PrioritiesAlreadyAssignedException.class)
    public void When_setting_priorities_to_a_list_with_priorities_already_set_an_exception_is_thrown() throws NoRegisteredPatientsException, PrioritiesAlreadyAssignedException {
        VaccinationListManager listManager = new VaccinationListManager();

        Patient p1 = new Patient("name1", 90, false);
        Patient p2 = new Patient("name2", 95, false);
        Patient p3 = new Patient("name3", 100, false);
        listManager.addPatient(p1);
        listManager.addPatient(p2);
        listManager.addPatient(p3);

        listManager.setPriorities();
        listManager.setPriorities();
    }

    private void AssertNextGroup(PQGroup nextGroup, ArrayList<Patient> listForPriorityN, int priority) {
        assertThat(listForPriorityN.size(), is(nextGroup.size()));
        assertThat(nextGroup.getPriority(), is(priority));

        for (Patient patient : listForPriorityN) {
            Boolean found = nextGroup.getPatients().stream().filter((q) -> q.equals(patient))
                    .findFirst()
                    .orElse(null) != null;

            assertThat(found, is(true));
        }
    }
}
