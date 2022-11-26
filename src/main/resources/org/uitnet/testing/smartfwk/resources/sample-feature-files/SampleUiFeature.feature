# Sample UI Feature file
# ======================
# NOTE1: All scenarios should be independent means one scenario should not depend on any other 
#        scenario. So that it can run in parallel.
# NOTE2: Apply the appropriate tags on the scenario to group the test scenarios. 
#        Default tags supported by framework: 
#        @Pending: Scenarios that are not implemented called pending. These will get skipped at run time.
#          Once steps are written then this tag should be removed and apply the @TempScenario tag to perform
#          unit test.
#        @TempScenario: Scenarios that are identified as Temp Test scenarios. Generally testers use this 
#          tag during the scenario development time to perform unit testing. Once unit testing done then 
#          remove this tag and apply the appropriate tag given below.
#        @RegressionTest: Scenarios that are identified as Regression Test scenarios.
#        @SmokeTest: Scenarios that are identified as Smoke Test scenarios.
#        @SanityTest: Scenarios that are identified as Sanity Test scenarios.
# @FeatureTag: Feature tag is the where all scenarios listed in this feature file belong to. For example
#        You can say @UserManagement or @UserRoleManagement etc..
# References: Default cucumber step definitions are present at the following Github path:
#        English: https://github.com/mkrishna4u/smart-testauto-cucumber-stepdefs-en/tree/main/src/main/java/org/uitnet/testing/smartfwk/core/stepdefs/en
#        Make sure your project pom.xml file has the correct version of the "smart-testauto-cucumber-stepdefs-en.version" property.
#        NOTE-A: These step definitions are the default step definitions and you can also be able to write your step definition in the following directory:
#          "src/test/java/stepdefs". Recommended to add prefix [C] to all custom steps implemented in your project to avoid conflict with default step 
#          definitions (Provided by Smart Framework). Like:
#            @When [C] user click on X menu item.
#            @Then [C] then X page is opened.

@FeatureTag
Feature: (Provide title of your feature here)
  (Add short description of your feature)cucumber

  @RegressionTest @SmokeTest @SanityTest @TempScenario
  Scenario: [SampleScenario] Verify the home page navigation.
    Given user profile "SampleUserProfile" is already activated on "(app-name)" application.
    When click on "(app-name).SamplePO.MenuItem_Home" page element.
    Then "Home page" will be "opened".
    And verify that the following page elements are visible:
      | Page Element                       |
      | (app-name).SamplePO.PageTitle_Home |
    And verify that the following page elements are not visible:
      | Page Element                              |
      | (app-name).SamplePO.Textbox_HiddenElement |
      
  @RegressionTest @SmokeTest @SanityTest @TempScenario
  Scenario Outline: [SampleScenario] Verify the home page navigation using different user profiles/roles.
    Given user profile "<User Profile Name>" is already activated on "(app-name)" application.
    When click on "(app-name).SamplePO.MenuItem_Home" page element.
    Then "Home page" will be "opened".
    And verify that the following page elements are visible:
      | Page Element                       |
      | (app-name).SamplePO.PageTitle_Home |
    And verify that the following page elements are not visible:
      | Page Element                              |
      | (app-name).SamplePO.Textbox_HiddenElement |
    
    Examples:
      | User Profile Name | Visible Element | Hidden Element |
      | SampleUserProfile  | (app-name).SamplePO.PageTitle_Home |(app-name).SamplePO.Textbox_HiddenElement |