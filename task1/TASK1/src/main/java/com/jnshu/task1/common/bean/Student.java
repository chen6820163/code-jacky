package com.jnshu.task1.common.bean;

/**
 * @program: TASK1
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-05 19:48
 * @contact:938738637@qq.com
 **/
public class Student {
    private long id;
    private long createAt;
    private long updateAt;
    private String name;
    private long QQ;
    private String chosseStudyType;
    private long roughlyStudyTime;
    private String graduateSchool;
    private long onlineStudyId;
    private String dailyLink;
    private String coachSenior;
    private String declaration;
    private String whereToKnow;

    public Student() {
    }

    public Student(long id, long createAt, long updateAt, String name, long QQ, String chosseStudyType, long roughlyStudyTime, String graduateSchool, long onlineStudyId, String dailyLink, String coachSenior, String declaration, String whereToKnow) {
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.name = name;
        this.QQ = QQ;
        this.chosseStudyType = chosseStudyType;
        this.roughlyStudyTime = roughlyStudyTime;
        this.graduateSchool = graduateSchool;
        this.onlineStudyId = onlineStudyId;
        this.dailyLink = dailyLink;
        this.coachSenior = coachSenior;
        this.declaration = declaration;
        this.whereToKnow = whereToKnow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQQ() {
        return QQ;
    }

    public void setQQ(long QQ) {
        this.QQ = QQ;
    }

    public String getChosseStudyType() {
        return chosseStudyType;
    }

    public void setChosseStudyType(String chosseStudyType) {
        this.chosseStudyType = chosseStudyType;
    }

    public long getRoughlyStudyTime() {
        return roughlyStudyTime;
    }

    public void setRoughlyStudyTime(long roughlyStudyTime) {
        this.roughlyStudyTime = roughlyStudyTime;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public long getOnlineStudyId() {
        return onlineStudyId;
    }

    public void setOnlineStudyId(long onlineStudyId) {
        this.onlineStudyId = onlineStudyId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getCoachSenior() {
        return coachSenior;
    }

    public void setCoachSenior(String coachSenior) {
        this.coachSenior = coachSenior;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getWhereToKnow() {
        return whereToKnow;
    }

    public void setWhereToKnow(String whereToKnow) {
        this.whereToKnow = whereToKnow;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", QQ=" + QQ +
                ", chosseStudyType='" + chosseStudyType + '\'' +
                ", roughlyStudyTime=" + roughlyStudyTime +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", onlineStudyId=" + onlineStudyId +
                ", dailyLink='" + dailyLink + '\'' +
                ", coachSenior='" + coachSenior + '\'' +
                ", declaration='" + declaration + '\'' +
                ", whereToKnow='" + whereToKnow + '\'' +
                '}';
    }
}
