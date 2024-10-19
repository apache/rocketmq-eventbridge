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
// EventTarget Controller apis:
//
// createEventTargets *
//
// updateEventTargets *
//
// deleteEventTargets *
//
// listEventTargets   *
func (client *DemoClient) TestCreateEventTargets() (_err error) {
	config_ := map[string]interface{}{
		"fileName": "~/Target",
		"line":     "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
	}
	config2_ := map[string]interface{}{
		"fileName": "~/Target222",
		"line":     "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
	}
	request := &sdkclient.CreateEventTargetsRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
		EventTargets: []*sdkclient.EventTarget{&sdkclient.EventTarget{
			EventTargetName: tea.String("newTarget"),
			ClassName:       tea.String("file"),
			Config:          config_,
			RunOptions: &sdkclient.EventTargetRunOptions{
				ErrorsTolerance: tea.String(""),
				RetryStrategy: &sdkclient.EventTargetRunOptionsRetryStrategy{
					PushRetryStrategy:        tea.String(""),
					MaximumEventAgeInSeconds: tea.Int32(100),
					MaximumRetryAttempts:     tea.Int32(100),
				},
				DeadLetterQueue: &sdkclient.EventTargetRunOptionsDeadLetterQueue{
					Type: tea.String(""),
				},
			},
		}, &sdkclient.EventTarget{
			EventTargetName: tea.String("newTarget222"),
			ClassName:       tea.String("file"),
			Config:          config2_,
			RunOptions: &sdkclient.EventTargetRunOptions{
				ErrorsTolerance: tea.String(""),
				RetryStrategy: &sdkclient.EventTargetRunOptionsRetryStrategy{
					PushRetryStrategy:        tea.String(""),
					MaximumEventAgeInSeconds: tea.Int32(100),
					MaximumRetryAttempts:     tea.Int32(100),
				},
				DeadLetterQueue: &sdkclient.EventTargetRunOptionsDeadLetterQueue{
					Type: tea.String(""),
				},
			},
		}},
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
		res, _err := client.SdkClient.CreateEventTargets(request)
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

func (client *DemoClient) TestUpdateEventTargets() (_err error) {
	config_ := map[string]interface{}{
		"fileName": "~/Target",
		"line":     "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
	}
	config2_ := map[string]interface{}{
		"fileName": "~/Target222",
		"line":     "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
	}
	request := &sdkclient.UpdateEventTargetsRequest{
		EventBusName:  tea.String("newBus"),
		EventRuleName: tea.String("newRule"),
		EventTargets: []*sdkclient.EventTarget{&sdkclient.EventTarget{
			EventTargetName: tea.String("newTarget"),
			ClassName:       tea.String("file"),
			Config:          config_,
		}, &sdkclient.EventTarget{
			EventTargetName: tea.String("newTarget222"),
			ClassName:       tea.String("file"),
			Config:          config2_,
		}},
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
		res, _err := client.SdkClient.UpdateEventTargets(request)
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

func (client *DemoClient) TestDeleteEventTargets() (_err error) {
	request := &sdkclient.DeleteEventTargetsRequest{
		EventBusName:     tea.String("newBus"),
		EventRuleName:    tea.String("newRule"),
		EventTargetNames: []*string{tea.String("newTarget"), tea.String("newTarget222")},
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
		res, _err := client.SdkClient.DeleteEventTargets(request)
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

func (client *DemoClient) TestListEventTargets() (_err error) {
	request := &sdkclient.ListEventTargetsRequest{
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
		res, _err := client.SdkClient.ListEventTargets(request)
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
