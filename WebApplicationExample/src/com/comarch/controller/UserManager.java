package com.comarch.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.comarch.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Adam Kołodziejek
 * @since 09-07-2017
 */

@Slf4j
@ManagedBean
@SessionScoped
public class UserManager {

    public static final String HOME_PAGE_REDIRECT = "/secured/home.xhtml?faces-redirect=true";
    public static final String LOGOUT_PAGE_REDIRECT = "/logout.xhtml?faces-redirect=true";

    private String userId;
    private String userPassword;
    private User currentUser;

    public String login() {
        // lookup the user based on user name and user password
        currentUser = find(userId, userPassword);

        if (currentUser != null) {
            log.info("login successful for '{}'", userId);

            return HOME_PAGE_REDIRECT;
        } else {
            log.info("login failed for '{}'", userId);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Login failed",
                            "Invalid or unknown credentials."));

            return null;
        }
    }

    public String logout() {
        String identifier = userId;

        // invalidate the session
        log.debug("invalidating session for '{}'", identifier);
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();

        log.info("logout successful for '{}'", identifier);
        return LOGOUT_PAGE_REDIRECT;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return HOME_PAGE_REDIRECT;
        }

        return null;
    }

    private User find(String userId, String password) {
        User result = null;

        // code block to be replaced with actual retrieval of user
        if ("adam".equalsIgnoreCase(userId)
                && "test1234".equals(password)) {
            result = new User(userId, "Adam", "Kołodziejek");
        }

        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
