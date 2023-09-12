package test.cases.trello;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.jira.IssuePage;
import pages.jira.IssuesPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueTest extends BaseTest {
    private IssuesPage issuesPage;
    private  IssuePage issuePage;
    public static String timestamp = BaseTest.timestamp;

    @Before
    public void pageSetup() {
        issuesPage = new IssuesPage(actions.getDriver());
        issuePage = new IssuePage(actions.getDriver());
    }

    @Test
    public void test1_createNewStory_when_CreateButtonClicked() {
        login();

        issuesPage.createIssueStory();

        issuePage.asserStoryIsCreated();
    }

    @Test
    public void test2_createNewBug_when_CreateButtonClicked() {
        issuesPage.createIssueBug();

        issuePage.assertBugIsCreated();
    }

    @Test
    public void test3_linkBugToStory() {
        issuePage.linkBugToStory();

        issuePage.assertCorrectRelationStatus();

        issuePage.assertRelateStoryIsCorrect();
    }
}
