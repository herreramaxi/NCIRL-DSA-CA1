/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Exceptions.NoRegisteredPatientsException;
import Model.Exceptions.PrioritiesAlreadyAssignedException;
import Model.Person;
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
        Person p1 = new Person("name1", 45, false);

        assertThat(0, is(listManager.size()));
        assertThat(0, is(listManager.getAllRegisteredPatients().size()));

        listManager.addPerson(p1);
        assertThat(1, is(listManager.size()));
        assertThat(1, is(listManager.getAllRegisteredPatients().size()));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p1)).findFirst().orElse(null));

        Person p2 = new Person("name2", 32, false);
        listManager.addPerson(p2);
        assertThat(2, is(listManager.size()));
        assertThat(2, is(listManager.getAllRegisteredPatients().size()));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p1)).findFirst().orElse(null));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p2)).findFirst().orElse(null));
    }

    @Test
    public void when_identifying_next_group_of_people_they_are_removed_from_the_list() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException {
        VaccinationListManager listManager = new VaccinationListManager();
        Person p4 = new Person("priority 4", 45, false);
        Person p3 = new Person("priority 3", 32, false);

        listManager.addPerson(p3);
        listManager.addPerson(p4);

        assertThat(2, is(listManager.size()));
        assertThat(2, is(listManager.getAllRegisteredPatients().size()));

        ArrayList<Person> nextGroup = listManager.getNextGroupToBeScheduled();
        assertThat(0, is(nextGroup.size()));
        assertThat(2, is(listManager.size()));

        listManager.setPriorities();

        nextGroup = listManager.getNextGroupToBeScheduled();
        assertThat(1, is(nextGroup.size()));
        assertThat(1, is(listManager.size()));
        assertThat(1, is(listManager.getAllRegisteredPatients().size()));
        assertNotNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p3)).findFirst().orElse(null));
        assertNull(listManager.getAllRegisteredPatients().stream().filter(x -> x.equals(p4)).findFirst().orElse(null));
        assertNotNull(nextGroup.stream().filter(x -> x.equals(p4)).findFirst().orElse(null));

        nextGroup = listManager.getNextGroupToBeScheduled();
        assertThat(1, is(nextGroup.size()));
        assertNotNull(nextGroup.stream().filter(x -> x.equals(p3)).findFirst().orElse(null));
        assertThat(0, is(listManager.size()));
        assertThat(0, is(listManager.getAllRegisteredPatients().size()));
    }

    @Test
    public void When_removing_next_group_it_is_the_expected() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException {
        ArrayList<Person> list = new ArrayList<>();
        VaccinationListManager listManager = new VaccinationListManager();
        //- Priority 10: People aged 90 and older        
        Person p1 = new Person("name1", 90, false);
        Person p2 = new Person("name2", 95, false);
        Person p3 = new Person("name3", 100, false);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        ArrayList<Person> priority10 = new ArrayList<>();
        priority10.add(p1);
        priority10.add(p2);
        priority10.add(p3);

        //- Priority 9: People aged 80 and older 
        Person p4 = new Person("name1", 80, false);
        Person p5 = new Person("name2", 82, false);
        Person p6 = new Person("name3", 89, false);

        list.add(p4);
        list.add(p5);
        list.add(p6);

        ArrayList<Person> priority9 = new ArrayList<>();
        priority9.add(p4);
        priority9.add(p5);
        priority9.add(p6);

        //- Priority 8: People aged 70 and older 
        Person p7 = new Person("name7", 70, false);
        Person p8 = new Person("name8", 74, false);
        Person p9 = new Person("name9", 79, false);

        list.add(p7);
        list.add(p8);
        list.add(p9);

        ArrayList<Person> priority8 = new ArrayList<>();
        priority8.add(p7);
        priority8.add(p8);
        priority8.add(p9);

        //- Priority 7: People aged 65-69 
        Person p10 = new Person("name10", 65, false);
        Person p11 = new Person("name11", 67, false);
        Person p12 = new Person("name12", 69, false);

        list.add(p10);
        list.add(p11);
        list.add(p12);

        ArrayList<Person> priority7 = new ArrayList<>();
        priority7.add(p10);
        priority7.add(p11);
        priority7.add(p12);

        //- Priority 6: People aged 18-64 with medical condition(s) 
        Person p13 = new Person("name13", 18, true);
        Person p14 = new Person("name14", 50, true);
        Person p15 = new Person("name15", 64, true);

        list.add(p13);
        list.add(p14);
        list.add(p15);

        ArrayList<Person> priority6 = new ArrayList<>();
        priority6.add(p13);
        priority6.add(p14);
        priority6.add(p15);

        //- Priority 5: People aged 55-64 
        Person p16 = new Person("name16", 55, false);
        Person p17 = new Person("name17", 58, false);
        Person p18 = new Person("name18", 64, false);

        list.add(p16);
        list.add(p17);
        list.add(p18);

        ArrayList<Person> priority5 = new ArrayList<>();
        priority5.add(p16);
        priority5.add(p17);
        priority5.add(p18);

        //- Priority 4: People aged 45-54 
        Person p19 = new Person("name19", 45, false);
        Person p20 = new Person("name20", 50, false);
        Person p21 = new Person("name21", 54, false);

        list.add(p19);
        list.add(p20);
        list.add(p21);

        ArrayList<Person> priority4 = new ArrayList<>();
        priority4.add(p19);
        priority4.add(p20);
        priority4.add(p21);

        //- Priority 3: People aged 30-44 
        Person p22 = new Person("name22", 30, false);
        Person p23 = new Person("name23", 40, false);
        Person p24 = new Person("name24", 44, false);

        list.add(p22);
        list.add(p23);
        list.add(p24);

        ArrayList<Person> priority3 = new ArrayList<>();
        priority3.add(p22);
        priority3.add(p23);
        priority3.add(p24);

        //- Priority 2: people aged 18-29 
        Person p25 = new Person("name25", 18, false);
        Person p26 = new Person("name26", 25, false);
        Person p27 = new Person("name27", 29, false);

        list.add(p25);
        list.add(p26);
        list.add(p27);

        ArrayList<Person> priority2 = new ArrayList<>();
        priority2.add(p25);
        priority2.add(p26);
        priority2.add(p27);

        //- Priority 1: People aged under 18
        Person p28 = new Person("name28", 5, false);
        Person p29 = new Person("name29", 10, false);
        Person p30 = new Person("name30", 17, false);

        list.add(p28);
        list.add(p29);
        list.add(p30);

        ArrayList<Person> priority1 = new ArrayList<>();
        priority1.add(p28);
        priority1.add(p29);
        priority1.add(p30);

        Collections.shuffle(list);

        list.forEach((person) -> {
            listManager.addPerson(person);
        });

        listManager.setPriorities();

        ArrayList<Person> nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority10);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority9);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority8);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority7);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority6);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority5);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority4);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority3);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority2);

        nextGroup = listManager.getNextGroupToBeScheduled();
        AssertNextGroup(nextGroup, priority1);

        nextGroup = listManager.getNextGroupToBeScheduled();
        assertThat(0, is(nextGroup.size()));
    }

    @Test(expected = NoRegisteredPatientsException.class)
    public void When_setting_priorities_to_an_empty_list_an_exception_is_thrown() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException {
        VaccinationListManager listManager = new VaccinationListManager();

        listManager.setPriorities();
    }

    @Test(expected = PrioritiesAlreadyAssignedException.class)
    public void When_setting_priorities_to_a_list_with_priorities_already_set_an_exception_is_thrown() throws NoRegisteredPatientsException, PrioritiesAlreadyAssignedException {
        VaccinationListManager listManager = new VaccinationListManager();

        Person p1 = new Person("name1", 90, false);
        Person p2 = new Person("name2", 95, false);
        Person p3 = new Person("name3", 100, false);
        listManager.addPerson(p1);
        listManager.addPerson(p2);
        listManager.addPerson(p3);

        listManager.setPriorities();
        listManager.setPriorities();
    }

    private void AssertNextGroup(ArrayList<Person> nextGroup, ArrayList<Person> listForPriorityN) {
        assertThat(listForPriorityN.size(), is(nextGroup.size()));

        for (Person person : listForPriorityN) {
            Boolean found = nextGroup.stream().filter((q) -> q.equals(person))
                    .findFirst()
                    .orElse(null) != null;

            assertThat(found, is(true));
        }
    }
}
