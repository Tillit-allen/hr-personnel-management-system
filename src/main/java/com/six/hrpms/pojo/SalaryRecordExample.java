package com.six.hrpms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(Double value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(Double value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(Double value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(Double value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(Double value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<Double> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<Double> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(Double value1, Double value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(Double value1, Double value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNull() {
            addCriterion("work_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("work_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(Double value) {
            addCriterion("work_time =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(Double value) {
            addCriterion("work_time <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(Double value) {
            addCriterion("work_time >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("work_time >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(Double value) {
            addCriterion("work_time <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(Double value) {
            addCriterion("work_time <=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIn(List<Double> values) {
            addCriterion("work_time in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<Double> values) {
            addCriterion("work_time not in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(Double value1, Double value2) {
            addCriterion("work_time between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(Double value1, Double value2) {
            addCriterion("work_time not between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeIsNull() {
            addCriterion("late_time is null");
            return (Criteria) this;
        }

        public Criteria andLateTimeIsNotNull() {
            addCriterion("late_time is not null");
            return (Criteria) this;
        }

        public Criteria andLateTimeEqualTo(Double value) {
            addCriterion("late_time =", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeNotEqualTo(Double value) {
            addCriterion("late_time <>", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeGreaterThan(Double value) {
            addCriterion("late_time >", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("late_time >=", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeLessThan(Double value) {
            addCriterion("late_time <", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeLessThanOrEqualTo(Double value) {
            addCriterion("late_time <=", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeIn(List<Double> values) {
            addCriterion("late_time in", values, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeNotIn(List<Double> values) {
            addCriterion("late_time not in", values, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeBetween(Double value1, Double value2) {
            addCriterion("late_time between", value1, value2, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeNotBetween(Double value1, Double value2) {
            addCriterion("late_time not between", value1, value2, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeIsNull() {
            addCriterion("leave_early_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeIsNotNull() {
            addCriterion("leave_early_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeEqualTo(Double value) {
            addCriterion("leave_early_time =", value, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeNotEqualTo(Double value) {
            addCriterion("leave_early_time <>", value, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeGreaterThan(Double value) {
            addCriterion("leave_early_time >", value, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("leave_early_time >=", value, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeLessThan(Double value) {
            addCriterion("leave_early_time <", value, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeLessThanOrEqualTo(Double value) {
            addCriterion("leave_early_time <=", value, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeIn(List<Double> values) {
            addCriterion("leave_early_time in", values, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeNotIn(List<Double> values) {
            addCriterion("leave_early_time not in", values, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeBetween(Double value1, Double value2) {
            addCriterion("leave_early_time between", value1, value2, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimeNotBetween(Double value1, Double value2) {
            addCriterion("leave_early_time not between", value1, value2, "leaveEarlyTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNull() {
            addCriterion("business_time is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNotNull() {
            addCriterion("business_time is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEqualTo(Double value) {
            addCriterion("business_time =", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotEqualTo(Double value) {
            addCriterion("business_time <>", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThan(Double value) {
            addCriterion("business_time >", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("business_time >=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThan(Double value) {
            addCriterion("business_time <", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThanOrEqualTo(Double value) {
            addCriterion("business_time <=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIn(List<Double> values) {
            addCriterion("business_time in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotIn(List<Double> values) {
            addCriterion("business_time not in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeBetween(Double value1, Double value2) {
            addCriterion("business_time between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotBetween(Double value1, Double value2) {
            addCriterion("business_time not between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyIsNull() {
            addCriterion("business_money is null");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyIsNotNull() {
            addCriterion("business_money is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyEqualTo(Double value) {
            addCriterion("business_money =", value, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyNotEqualTo(Double value) {
            addCriterion("business_money <>", value, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyGreaterThan(Double value) {
            addCriterion("business_money >", value, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("business_money >=", value, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyLessThan(Double value) {
            addCriterion("business_money <", value, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyLessThanOrEqualTo(Double value) {
            addCriterion("business_money <=", value, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyIn(List<Double> values) {
            addCriterion("business_money in", values, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyNotIn(List<Double> values) {
            addCriterion("business_money not in", values, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyBetween(Double value1, Double value2) {
            addCriterion("business_money between", value1, value2, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andBusinessMoneyNotBetween(Double value1, Double value2) {
            addCriterion("business_money not between", value1, value2, "businessMoney");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeIsNull() {
            addCriterion("overtime_time is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeIsNotNull() {
            addCriterion("overtime_time is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeEqualTo(Double value) {
            addCriterion("overtime_time =", value, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeNotEqualTo(Double value) {
            addCriterion("overtime_time <>", value, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeGreaterThan(Double value) {
            addCriterion("overtime_time >", value, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("overtime_time >=", value, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeLessThan(Double value) {
            addCriterion("overtime_time <", value, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeLessThanOrEqualTo(Double value) {
            addCriterion("overtime_time <=", value, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeIn(List<Double> values) {
            addCriterion("overtime_time in", values, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeNotIn(List<Double> values) {
            addCriterion("overtime_time not in", values, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeBetween(Double value1, Double value2) {
            addCriterion("overtime_time between", value1, value2, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeTimeNotBetween(Double value1, Double value2) {
            addCriterion("overtime_time not between", value1, value2, "overtimeTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNull() {
            addCriterion("leave_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNotNull() {
            addCriterion("leave_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeEqualTo(Double value) {
            addCriterion("leave_time =", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotEqualTo(Double value) {
            addCriterion("leave_time <>", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThan(Double value) {
            addCriterion("leave_time >", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("leave_time >=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThan(Double value) {
            addCriterion("leave_time <", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThanOrEqualTo(Double value) {
            addCriterion("leave_time <=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIn(List<Double> values) {
            addCriterion("leave_time in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotIn(List<Double> values) {
            addCriterion("leave_time not in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeBetween(Double value1, Double value2) {
            addCriterion("leave_time between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotBetween(Double value1, Double value2) {
            addCriterion("leave_time not between", value1, value2, "leaveTime");
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