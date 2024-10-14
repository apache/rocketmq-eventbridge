// This file is auto-generated, don't edit it. Thanks.
package client

import (
	openapi "github.com/alibabacloud-go/darabonba-openapi/v2/client"
	console "github.com/alibabacloud-go/tea-console/client"
	util "github.com/alibabacloud-go/tea-utils/v2/service"
	"github.com/alibabacloud-go/tea/tea"
	sdkclient "github.com/org-apache-rocketmq/eventbridge-sdk/client"
)

type DemoClient struct {
	SdkClient *sdkclient.Client
	Endpoint  *string
}

func NewClient() (*DemoClient, error) {
	client := new(DemoClient)
	err := client.Init()
	return client, err
}

func (client *DemoClient) Init() (_err error) {
	client.Endpoint = tea.String("127.0.0.1:7001")
	config := &openapi.Config{
		Endpoint: client.Endpoint,
	}
	client.SdkClient, _err = sdkclient.NewClient(config)
	if _err != nil {
		return _err
	}

	return nil
}

// Description:
//
// EventRule Controller apis:
//
// createEventRule  *
//
// getEventRule     *
//
// deleteEventRule  *
//
// updateEventRule  *
//
// listEventRules   *
//
// enableEventRule  *
//
// disableEventRule *
func (client *DemoClient) TestCreateEventRule() (_err error) {
	request := &sdkclient.CreateEventRuleRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
		Description:   tea.String("an event rule for test"),
		FilterPattern: tea.String("{}"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.CreateEventRule(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}

func (client *DemoClient) TestGetEventRule() (_err error) {
	request := &sdkclient.GetEventRuleRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.GetEventRule(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}

func (client *DemoClient) TestDeleteEventRule() (_err error) {
	request := &sdkclient.DeleteEventRuleRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.DeleteEventRule(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}

func (client *DemoClient) TestUpdateEventRule() (_err error) {
	request := &sdkclient.UpdateEventRuleRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
		Description:   tea.String("new description for testing update API"),
		FilterPattern: tea.String("{}"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.UpdateEventRule(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}

func (client *DemoClient) TestListEventRules() (_err error) {
	request := &sdkclient.ListEventRulesRequest{
		EventBusName: tea.String("newBus"),
		MaxResults:   tea.Int32(2),
		NextToken:    tea.String("0"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.ListEventRules(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}

func (client *DemoClient) TestEnableEventRule() (_err error) {
	request := &sdkclient.EnableEventRuleRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.EnableEventRule(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}

func (client *DemoClient) TestDisableEventRule() (_err error) {
	request := &sdkclient.DisableEventRuleRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
	}
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.DisableEventRule(request)
		if _err != nil {
			return _err
		}

		console.Log(util.ToJSONString(res.Body))

		return nil
	}()

	if tryErr != nil {
		var err = &tea.SDKError{}
		if _t, ok := tryErr.(*tea.SDKError); ok {
			err = _t
		} else {
			err.Message = tea.String(tryErr.Error())
		}
		console.Log(tea.String("err!"))
		console.Log(err.Message)
	}
	return _err
}
