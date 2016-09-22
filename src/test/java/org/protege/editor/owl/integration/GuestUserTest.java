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
public class GuestUserTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        startCleanServer();
    }

    @After
    public void cleanUp() throws Exception {
        stopServer();
    }

    @Test
    public void couldLoginAsGuest() throws Exception {
        LocalHttpClient guest = connectAsGuest();
        
        // Assert user guest
        assertThat(guest, is(not(nullValue())));
        assertThat(guest.getUserInfo().getId(), is("guest"));
        assertThat(guest.getUserInfo().getName(), is("Guest User"));
        assertThat(guest.getUserInfo().getEmailAddress(), is(""));
    }

    @Test
    public void couldQueryDefaultPolicyOperations() throws Exception {
        LocalHttpClient guest = connectAsGuest();
        
        // Assert allowed operations
        assertThat(guest.getConfig().canAssignRole(), is(false));
        assertThat(guest.getConfig().canCreateOperation(), is(false));
        assertThat(guest.getConfig().canCreateProject(), is(false));
        assertThat(guest.getConfig().canCreateRole(), is(false));
        assertThat(guest.getConfig().canCreateUser(), is(false));
        assertThat(guest.getConfig().canDeleteOperation(), is(false));
        assertThat(guest.getConfig().canDeleteProject(), is(false));
        assertThat(guest.getConfig().canDeleteRole(), is(false));
        assertThat(guest.getConfig().canDeleteUser(), is(false));
        assertThat(guest.getConfig().canOpenProject(), is(true));
        assertThat(guest.getConfig().canRetractRole(), is(false));
        assertThat(guest.getConfig().canStopServer(), is(false));
        assertThat(guest.getConfig().canUpdateOperation(), is(false));
        assertThat(guest.getConfig().canUpdateProject(), is(false));
        assertThat(guest.getConfig().canUpdateRole(), is(false));
        assertThat(guest.getConfig().canUpdateServerConfig(), is(false));
        assertThat(guest.getConfig().canUpdateUser(), is(false));
    }

    @Test
    public void couldBrowseAllUsers() throws Exception {
        LocalHttpClient guest = connectAsGuest();
        
        // Perform the action
        List<User> users = guest.getConfig().getAllUsers();
        
        // Assert user list
        assertThat(users, is(not(nullValue())));
    }

    @Test
    public void couldBrowseAllProjects() throws Exception {
        LocalHttpClient guest = connectAsGuest();
        
        // Perform the action
        List<Project> projects = guest.getConfig().getAllProjects();
        
        // Assert user list
        assertThat(projects, is(not(nullValue())));
    }

    @Test
    public void couldBrowseAllRoles() throws Exception {
        LocalHttpClient guest = connectAsGuest();
        
        // Perform the action
        List<Role> roles = guest.getConfig().getAllRoles();
        
        // Assert user list
        assertThat(roles, is(not(nullValue())));
    }

    @Test
    public void couldBrowseAllOperations() throws Exception {
        LocalHttpClient guest = connectAsGuest();
        
        // Perform the action
        List<Operation> operations = guest.getConfig().getAllOperations();
        
        // Assert user list
        assertThat(operations, is(not(nullValue())));
    }
}
