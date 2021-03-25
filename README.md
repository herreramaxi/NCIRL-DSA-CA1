# NCIRL-DSA-CA1

#### How to run the application
- Right click on the project "VaccinationScheduleSystem", select Run (or F6).
- Or open [VaccinationScheduleSystem.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/StartingPoint/VaccinationScheduleSystem.java) and click in play or F6.

#### Test cases
- [VaccinationListManagerTests.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/test/VaccinationListManagerTests.java)
- How to run the test cases on **Netbeans**
    - Click right on [VaccinationListManagerTests.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/test/VaccinationListManagerTests.java) and select "Test File".
    - Another option is to open above file and right click on any part of the source code, select "Test File" (Ctrl+F6).
    - Finally open Test result windows: Windows/IDE tools/Test Results (Alt+Shift+R)

##### Test cases result
<a href="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/TestCasesReport.JPG"><img src="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/TestCasesReport.JPG" align="center" height="200" width="450" ></a>

#### Data structures used:
- [Priority queue](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/Model/PriorityQueue.java): Enqueue patients according to their priorities.
- [ArrayList](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/1cf23ab1454396ef6560180a324a6c4a9fad0c86/src/Model/VaccinationListManager.java#L19): Add patients to be vaccinated.

#### Project structure
 - [src](https://github.com/herreramaxi/NCIRL-DSA-CA1/tree/main/src)
    -  [Model](https://github.com/herreramaxi/NCIRL-DSA-CA1/tree/main/src/Model)
    -  [StartingPoint](https://github.com/herreramaxi/NCIRL-DSA-CA1/tree/main/src/StartingPoint)
    -  [UI](https://github.com/herreramaxi/NCIRL-DSA-CA1/tree/main/src/UI)
        * [WorkflowManager](https://github.com/herreramaxi/NCIRL-DSA-CA1/tree/main/src/UI/WorkflowManager)

#### UI MainJFrame
- [MainJFrame.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/UI/MainJFrame.java)

#### Main classes
- [PriorityQueue.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/Model/PriorityQueue.java)
- [VaccinationListManager.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/Model/VaccinationListManager.java)
- [UIMediator.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/UI/UIMediator.java)
- [WorkflowManager.java](https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/src/UI/WorkflowManager/WorkflowManager.java)

#### Design - Mockup
<a href="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/ca%20mockup.png"><img src="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/ca%20mockup.png" align="center" height="350" width="350" ></a>

#### UI Implementation
<a href="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/Main%20frame.JPG"><img src="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/Main%20frame.JPG" align="center" height="350" width="350" ></a>

#### Workflow state machine
<a href="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/Workflow%20state%20machine.jpg"><img src="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/Workflow%20state%20machine.jpg" align="center" height="230" width="500" ></a>

#### Troubleshooting
* Error: lambda expressions are not supported in -source 1.7
  (use -source 8 or higher to enable lambda expressions)
* Solution: In Netbeans, right click on VaccinationScheduleSystem, properties, selects "Sources" category (left panel), on drop down "Source/Binary format"
select JDK 8.

<a href="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/JDK8.JPG"><img src="https://github.com/herreramaxi/NCIRL-DSA-CA1/blob/main/uml/JDK8.JPG" align="center" height="350" width="600" ></a>
