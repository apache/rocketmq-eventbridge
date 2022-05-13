package org.apache.rocketmq.eventbridge.domain.model.apidestination;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class EventApiDestination implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.id
     *
     * @mbggenerated
     */
    private Integer id;

    private String accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.protocol
     *
     * @mbggenerated
     */
    private String protocol;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.connection_name
     *
     * @mbggenerated
     */
    private String connectionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.invocation_rate_limit_per_second
     *
     * @mbggenerated
     */
    private Integer invocationRateLimitPerSecond;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.gmt_create
     *
     * @mbggenerated
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.gmt_modify
     *
     * @mbggenerated
     */
    private Date gmtModify;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column event_api_destination.api_params
     *
     * @mbggenerated
     */
    private String apiParams;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table event_api_destination
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.id
     *
     * @return the value of event_api_destination.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.id
     *
     * @param id the value for event_api_destination.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.name
     *
     * @return the value of event_api_destination.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.name
     *
     * @param name the value for event_api_destination.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.protocol
     *
     * @return the value of event_api_destination.protocol
     *
     * @mbggenerated
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.protocol
     *
     * @param protocol the value for event_api_destination.protocol
     *
     * @mbggenerated
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.connection_name
     *
     * @return the value of event_api_destination.connection_name
     *
     * @mbggenerated
     */
    public String getConnectionName() {
        return connectionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.connection_name
     *
     * @param connectionName the value for event_api_destination.connection_name
     *
     * @mbggenerated
     */
    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName == null ? null : connectionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.invocation_rate_limit_per_second
     *
     * @return the value of event_api_destination.invocation_rate_limit_per_second
     *
     * @mbggenerated
     */
    public Integer getInvocationRateLimitPerSecond() {
        return invocationRateLimitPerSecond;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.invocation_rate_limit_per_second
     *
     * @param invocationRateLimitPerSecond the value for event_api_destination.invocation_rate_limit_per_second
     *
     * @mbggenerated
     */
    public void setInvocationRateLimitPerSecond(Integer invocationRateLimitPerSecond) {
        this.invocationRateLimitPerSecond = invocationRateLimitPerSecond;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.description
     *
     * @return the value of event_api_destination.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.description
     *
     * @param description the value for event_api_destination.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.gmt_create
     *
     * @return the value of event_api_destination.gmt_create
     *
     * @mbggenerated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.gmt_create
     *
     * @param gmtCreate the value for event_api_destination.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.gmt_modify
     *
     * @return the value of event_api_destination.gmt_modify
     *
     * @mbggenerated
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.gmt_modify
     *
     * @param gmtModify the value for event_api_destination.gmt_modify
     *
     * @mbggenerated
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column event_api_destination.api_params
     *
     * @return the value of event_api_destination.api_params
     *
     * @mbggenerated
     */
    public String getApiParams() {
        return apiParams;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column event_api_destination.api_params
     *
     * @param apiParams the value for event_api_destination.api_params
     *
     * @mbggenerated
     */
    public void setApiParams(String apiParams) {
        this.apiParams = apiParams == null ? null : apiParams.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EventApiDestination that = (EventApiDestination) o;

        return new EqualsBuilder().append(id, that.id).append(accountId, that.accountId).append(name, that.name).append(protocol, that.protocol).append(connectionName, that.connectionName).append(invocationRateLimitPerSecond, that.invocationRateLimitPerSecond).append(description, that.description).append(gmtCreate, that.gmtCreate).append(gmtModify, that.gmtModify).append(apiParams, that.apiParams).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(accountId).append(name).append(protocol).append(connectionName).append(invocationRateLimitPerSecond).append(description).append(gmtCreate).append(gmtModify).append(apiParams).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("accountId", accountId)
                .append("name", name)
                .append("protocol", protocol)
                .append("connectionName", connectionName)
                .append("invocationRateLimitPerSecond", invocationRateLimitPerSecond)
                .append("description", description)
                .append("gmtCreate", gmtCreate)
                .append("gmtModify", gmtModify)
                .append("apiParams", apiParams)
                .toString();
    }
}