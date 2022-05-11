package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Parameter {

    private String name;

    private String description;

    private String type;

    private String defaultValue;

    private String in;
}
