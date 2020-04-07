$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("mobile-menu.feature");
formatter.feature({
  "line": 2,
  "name": "Menu feature",
  "description": "",
  "id": "menu-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@mobile"
    },
    {
      "line": 1,
      "name": "@mobile-regression"
    },
    {
      "line": 1,
      "name": "@menu"
    },
    {
      "line": 1,
      "name": "@regression-ridh"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Verify sidebar validation",
  "description": "",
  "id": "menu-feature;verify-sidebar-validation",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@menu-1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am on home page of the app",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click on hamburger menu",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I verify sidebar menu is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "MobileMenuSD.verifyIamOnHomePage()"
});
formatter.result({
  "duration": 39138431644,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.clickOnMenuButton()"
});
formatter.result({
  "duration": 1206177568,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.verifySidebarMenu()"
});
formatter.result({
  "duration": 1491166914,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify invalid signup",
  "description": "",
  "id": "menu-feature;verify-invalid-signup",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@menu-2"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I am on signup screen",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I tap on create button from signup screen",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I verify invalid password text",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I verify invalid username text",
  "keyword": "And "
});
formatter.match({
  "location": "MobileMenuSD.verifySinupScreen()"
});
formatter.result({
  "duration": 20982257364,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.tapOncreateButtonFromSignup()"
});
formatter.result({
  "duration": 226777248,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.verifyInvalidPassword()"
});
formatter.result({
  "duration": 4950765303,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.verifyInvalidUsername()"
});
formatter.result({
  "duration": 153666512,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify user should be able filter options",
  "description": "",
  "id": "menu-feature;verify-user-should-be-able-filter-options",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@menu-3"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "I am on home page of the app",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I click on filter button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I disable \u0027Angular\u0027 option",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I click on All Reset Filter button",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I verify all options are enabled",
  "keyword": "Then "
});
formatter.match({
  "location": "MobileMenuSD.verifyIamOnHomePage()"
});
formatter.result({
  "duration": 15473957506,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.clickOnfilterButton()"
});
formatter.result({
  "duration": 257178161,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.disableAngularOption()"
});
formatter.result({
  "duration": 2171328974,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.clickOnReset()"
});
formatter.result({
  "duration": 1098306424,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.verifyOptionEnabled()"
});
formatter.result({
  "duration": 2306003769,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Verify user should be able to slide right on tutorial pages",
  "description": "",
  "id": "menu-feature;verify-user-should-be-able-to-slide-right-on-tutorial-pages",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@menu-4"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "I am on Splash screen of the ionic conference app",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "I swipe right 3 times on tutorials slides",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I verify continue button",
  "keyword": "Then "
});
formatter.match({
  "location": "MobileMenuSD.verifyIamOnSplashScreen()"
});
formatter.result({
  "duration": 14429177977,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 14
    }
  ],
  "location": "MobileMenuSD.swipeRight3Times(int)"
});
formatter.result({
  "duration": 7280786050,
  "status": "passed"
});
formatter.match({
  "location": "MobileMenuSD.iverifyContinueButton()"
});
formatter.result({
  "duration": 195492582,
  "status": "passed"
});
});