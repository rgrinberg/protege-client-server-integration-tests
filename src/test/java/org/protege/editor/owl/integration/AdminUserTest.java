package org.protege.editor.owl.integration;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.protege.editor.owl.client.LocalHttpClient;

import edu.stanford.protege.metaproject.api.Operation;
import edu.stanford.protege.metaproject.api.Project;
import edu.stanford.protege.metaproject.api.Role;
import edu.stanford.protege.metaproject.api.User;

/**
 * @author Josef Hardi <johardi@stanford.edu> <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class AdminUserTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        startCleanServer();
    }

    @After
    public void cleanUp() throws Exception {
        stopServer();
    }

    @Test
    public void couldLoginAsAdmin() throws Exception {
        LocalHttpClient admin = connectAsAdmin();
        
        // Assert user admin
        assertThat(admin, is(not(nullValue())));
        assertThat(admin.getUserInfo().getId(), is("root"));
        assertThat(admin.getUserInfo().getName(), is("Root User"));
        assertThat(admin.getUserInfo().getEmailAddress(), is(""));
    }

    @Test
    public void couldQueryDefaultPolicyOperations() throws Exception {
        LocalHttpClient admin = connectAsAdmin();
        
        // Assert allowed operations
        assertThat(admin.getConfig().canAssignRole(), is(true));
        assertThat(admin.getConfig().canCreateOperation(), is(true));
        assertThat(admin.getConfig().canCreateProject(), is(true));
        assertThat(admin.getConfig().canCreateRole(), is(true));
        assertThat(admin.getConfig().canCreateUser(), is(true));
        assertThat(admin.getConfig().canDeleteOperation(), is(true));
        assertThat(admin.getConfig().canDeleteProject(), is(true));
        assertThat(admin.getConfig().canDeleteRole(), is(true));
        assertThat(admin.getConfig().canDeleteUser(), is(true));
        assertThat(admin.getConfig().canOpenProject(), is(true));
        assertThat(admin.getConfig().canRetractRole(), is(true));
        assertThat(admin.getConfig().canStopServer(), is(true));
        assertThat(admin.getConfig().canUpdateOperation(), is(true));
        assertThat(admin.getConfig().canUpdateProject(), is(true));
        assertThat(admin.getConfig().canUpdateRole(), is(true));
        assertThat(admin.getConfig().canUpdateServerConfig(), is(true));
        assertThat(admin.getConfig().canUpdateUser(), is(true));
    }

    @Test
    public void couldBrowseAllUsers() throws Exception {
        LocalHttpClient admin = connectAsAdmin();
        
        // Perform the action
        List<User> users = admin.getConfig().getAllUsers();
        
        // Assert user list
        assertThat(users, is(not(nullValue())));
    }

    @Test
    public void couldBrowseAllProjects() throws Exception {
        LocalHttpClient admin = connectAsAdmin();
        
        // Perform the action
        List<Project> projects = admin.getConfig().getAllProjects();
        
        // Assert user list
        assertThat(projects, is(not(nullValue())));
    }

    @Test
    public void couldBrowseAllRoles() throws Exception {
        LocalHttpClient admin = connectAsAdmin();
        
        // Perform the action
        List<Role> roles = admin.getConfig().getAllRoles();
        
        // Assert user list
        assertThat(roles, is(not(nullValue())));
    }

    @Test
    public void couldBrowseAllOperations() throws Exception {
        LocalHttpClient admin = connectAsAdmin();
        
        // Perform the action
        List<Operation> operations = admin.getConfig().getAllOperations();
        
        // Assert user list
        assertThat(operations, is(not(nullValue())));
    }
}
