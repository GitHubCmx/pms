package com.offcn.sys.bean;

public class EmpRole {
    private Integer eid;
    private Integer rid;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public EmpRole(Integer eid, Integer rid) {
        this.eid = eid;
        this.rid = rid;
    }
    public EmpRole() {

    }
}
