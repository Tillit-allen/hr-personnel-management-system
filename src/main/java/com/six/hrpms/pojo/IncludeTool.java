package com.six.hrpms.pojo;

public class IncludeTool {
    private Integer includeToolId;

    private String includeToolName;

    private Double score;

    private Integer isEffective;

    public Integer getIncludeToolId() {
        return includeToolId;
    }

    public void setIncludeToolId(Integer includeToolId) {
        this.includeToolId = includeToolId;
    }

    public String getIncludeToolName() {
        return includeToolName;
    }

    public void setIncludeToolName(String includeToolName) {
        this.includeToolName = includeToolName == null ? null : includeToolName.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Integer isEffective) {
        this.isEffective = isEffective;
    }
}