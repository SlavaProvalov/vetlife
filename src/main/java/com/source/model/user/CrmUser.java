package com.source.model.user;

import com.source.model.entity.Role;
import com.source.model.validation.FieldMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "{message.error.passwordMatch}")
})
// TODO different messages
public class CrmUser {

    @NotNull(message = "{message.error.requiredField}")
    @Size(min = 4, max = 16, message = "{message.error.requiredField}")
    private String userName;

    @NotNull(message = "{message.error.requiredField}")
    @Size(min = 4, max = 20, message = "{message.error.requiredField}")
    private String password;

    @NotNull(message = "{message.error.requiredField}")
    @Size(min = 4, max = 16, message = "{message.error.requiredField}")
    private String matchingPassword;

    @NotNull(message = "{message.error.requiredSelection}")
    private Collection<Role> roles;

    public CrmUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
