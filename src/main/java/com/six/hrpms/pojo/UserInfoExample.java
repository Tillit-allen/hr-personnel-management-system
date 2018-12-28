package com.six.hrpms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNull() {
            addCriterion("boss_name is null");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNotNull() {
            addCriterion("boss_name is not null");
            return (Criteria) this;
        }

        public Criteria andBossNameEqualTo(String value) {
            addCriterion("boss_name =", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotEqualTo(String value) {
            addCriterion("boss_name <>", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThan(String value) {
            addCriterion("boss_name >", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThanOrEqualTo(String value) {
            addCriterion("boss_name >=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThan(String value) {
            addCriterion("boss_name <", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThanOrEqualTo(String value) {
            addCriterion("boss_name <=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLike(String value) {
            addCriterion("boss_name like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotLike(String value) {
            addCriterion("boss_name not like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameIn(List<String> values) {
            addCriterion("boss_name in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotIn(List<String> values) {
            addCriterion("boss_name not in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameBetween(String value1, String value2) {
            addCriterion("boss_name between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotBetween(String value1, String value2) {
            addCriterion("boss_name not between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIsNull() {
            addCriterion("basic_salary is null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIsNotNull() {
            addCriterion("basic_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryEqualTo(Double value) {
            addCriterion("basic_salary =", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotEqualTo(Double value) {
            addCriterion("basic_salary <>", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryGreaterThan(Double value) {
            addCriterion("basic_salary >", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("basic_salary >=", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryLessThan(Double value) {
            addCriterion("basic_salary <", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryLessThanOrEqualTo(Double value) {
            addCriterion("basic_salary <=", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIn(List<Double> values) {
            addCriterion("basic_salary in", values, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotIn(List<Double> values) {
            addCriterion("basic_salary not in", values, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryBetween(Double value1, Double value2) {
            addCriterion("basic_salary between", value1, value2, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotBetween(Double value1, Double value2) {
            addCriterion("basic_salary not between", value1, value2, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andHomePlaceIsNull() {
            addCriterion("home_place is null");
            return (Criteria) this;
        }

        public Criteria andHomePlaceIsNotNull() {
            addCriterion("home_place is not null");
            return (Criteria) this;
        }

        public Criteria andHomePlaceEqualTo(String value) {
            addCriterion("home_place =", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceNotEqualTo(String value) {
            addCriterion("home_place <>", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceGreaterThan(String value) {
            addCriterion("home_place >", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("home_place >=", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceLessThan(String value) {
            addCriterion("home_place <", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceLessThanOrEqualTo(String value) {
            addCriterion("home_place <=", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceLike(String value) {
            addCriterion("home_place like", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceNotLike(String value) {
            addCriterion("home_place not like", value, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceIn(List<String> values) {
            addCriterion("home_place in", values, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceNotIn(List<String> values) {
            addCriterion("home_place not in", values, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceBetween(String value1, String value2) {
            addCriterion("home_place between", value1, value2, "homePlace");
            return (Criteria) this;
        }

        public Criteria andHomePlaceNotBetween(String value1, String value2) {
            addCriterion("home_place not between", value1, value2, "homePlace");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeIsNull() {
            addCriterion("basic_work_time is null");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeIsNotNull() {
            addCriterion("basic_work_time is not null");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeEqualTo(Integer value) {
            addCriterion("basic_work_time =", value, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeNotEqualTo(Integer value) {
            addCriterion("basic_work_time <>", value, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeGreaterThan(Integer value) {
            addCriterion("basic_work_time >", value, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic_work_time >=", value, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeLessThan(Integer value) {
            addCriterion("basic_work_time <", value, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeLessThanOrEqualTo(Integer value) {
            addCriterion("basic_work_time <=", value, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeIn(List<Integer> values) {
            addCriterion("basic_work_time in", values, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeNotIn(List<Integer> values) {
            addCriterion("basic_work_time not in", values, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeBetween(Integer value1, Integer value2) {
            addCriterion("basic_work_time between", value1, value2, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andBasicWorkTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("basic_work_time not between", value1, value2, "basicWorkTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeIsNull() {
            addCriterion("salary_time is null");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeIsNotNull() {
            addCriterion("salary_time is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeEqualTo(Date value) {
            addCriterion("salary_time =", value, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeNotEqualTo(Date value) {
            addCriterion("salary_time <>", value, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeGreaterThan(Date value) {
            addCriterion("salary_time >", value, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("salary_time >=", value, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeLessThan(Date value) {
            addCriterion("salary_time <", value, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeLessThanOrEqualTo(Date value) {
            addCriterion("salary_time <=", value, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeIn(List<Date> values) {
            addCriterion("salary_time in", values, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeNotIn(List<Date> values) {
            addCriterion("salary_time not in", values, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeBetween(Date value1, Date value2) {
            addCriterion("salary_time between", value1, value2, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andSalaryTimeNotBetween(Date value1, Date value2) {
            addCriterion("salary_time not between", value1, value2, "salaryTime");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorIsNull() {
            addCriterion("is_administrator is null");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorIsNotNull() {
            addCriterion("is_administrator is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorEqualTo(Integer value) {
            addCriterion("is_administrator =", value, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorNotEqualTo(Integer value) {
            addCriterion("is_administrator <>", value, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorGreaterThan(Integer value) {
            addCriterion("is_administrator >", value, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_administrator >=", value, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorLessThan(Integer value) {
            addCriterion("is_administrator <", value, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorLessThanOrEqualTo(Integer value) {
            addCriterion("is_administrator <=", value, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorIn(List<Integer> values) {
            addCriterion("is_administrator in", values, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorNotIn(List<Integer> values) {
            addCriterion("is_administrator not in", values, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorBetween(Integer value1, Integer value2) {
            addCriterion("is_administrator between", value1, value2, "isAdministrator");
            return (Criteria) this;
        }

        public Criteria andIsAdministratorNotBetween(Integer value1, Integer value2) {
            addCriterion("is_administrator not between", value1, value2, "isAdministrator");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}