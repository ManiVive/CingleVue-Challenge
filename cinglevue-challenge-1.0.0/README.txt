CingleVue Challenge - Steps to execute the Challenge
====================================================

1. Clone the repository at 'https://github.com/ManiVive/CingleVue-Challenge' to any folder in the machine.
2. Navigate to <CLONE_FOLDER>\CingleVue-Challenge\cinglevue-challenge-1.0.0\cinglevure-challenge where the pom.xml is located.
3. Open command prompt on this location.
4. Type the following command and run: 'mvn clean install'.
5. Wait for the dependencies to get downloaded (only at the first invocation).
6. Type the following command and run: 'mvn exec:java'.
7. Wait until Firefox browser opens and the application is run.
8. If the Assertion is successful, it'll display the number of hits found on 'http://www.cinglevue.com' and exit the application. Assertion error will occur otherwise.

Special Notes
=============
1. Please make sure that Mozilla Firefox is installed on your local machine and the version is up-to-date.
2. By changing the following parameters in the pom.xml, the application can be made to search for other texts than 'CingleVue'.
    <arguments>
        <argument>CingleVue</argument> - Search term
        <argument>10</argument> - Minimum No. of hits to verify (excluding).
    </arguments>