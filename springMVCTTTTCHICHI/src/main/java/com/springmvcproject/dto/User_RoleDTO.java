package com.springmvcproject.dto;
public class User_RoleDTO extends AbstractDTO<User_RoleDTO> {

    private Long usersid;
    private Long rolesid;

    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public Long getRolesid() {
        return rolesid;
    }

    public void setRolesid(Long rolesid) {
        this.rolesid = rolesid;
    }
}