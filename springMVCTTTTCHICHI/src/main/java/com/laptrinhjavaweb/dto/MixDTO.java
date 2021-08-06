package com.laptrinhjavaweb.dto;

import javax.persistence.Column;

public class MixDTO extends AbstractDTO<MixDTO> {

    private Long rolesId;
    private String rolesCode;
    private Long usersId;
    private String usersFullname;

    public Long getRolesId() {
        return rolesId;
    }

    public void setRolesId(Long rolesId) {
        this.rolesId = rolesId;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public void setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getUsersFullname() {
        return usersFullname;
    }

    public void setUsersFullname(String usersFullname) {
        this.usersFullname = usersFullname;
    }
}
