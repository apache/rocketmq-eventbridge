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
// EventSource Controller apis:
//
// createEventSource *
//
// updateEventSource *
//
// deleteEventSource *
//
// getEventSource    *
//
// listEventSources  *
func (client *DemoClient) TestCreateEventSource() (_err error) {
	request := &sdkclient.CreateEventSourceRequest{
		EventBusName:    tea.String("newBus"),
		EventSourceName: tea.String("newSource"),
		Description:     tea.String("a source for test"),
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
		res, _err := client.SdkClient.CreateEventSource(request)
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

func (client *DemoClient) TestUpdateEventSource() (_err error) {
	request := &sdkclient.UpdateEventSourceRequest{
		EventBusName:    tea.String("newBus"),
		EventSourceName: tea.String("newSource"),
		Description:     tea.String("new description for testing Update API"),
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
		res, _err := client.SdkClient.UpdateEventSource(request)
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

func (client *DemoClient) TestDeleteEventSource() (_err error) {
	request := &sdkclient.DeleteEventSourceRequest{
		EventBusName:    tea.String("newBus"),
		EventSourceName: tea.String("newSource"),
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
		res, _err := client.SdkClient.DeleteEventSource(request)
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

func (client *DemoClient) TestGetEventSource() (_err error) {
	request := &sdkclient.GetEventSourceRequest{
		EventBusName:    tea.String("newBus"),
		EventSourceName: tea.String("newSource"),
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
		res, _err := client.SdkClient.GetEventSource(request)
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

func (client *DemoClient) TestListEventSources() (_err error) {
	request := &sdkclient.ListEventSourcesRequest{
		EventBusName:    tea.String("newBus"),
		EventSourceType: tea.String("USER_DEFINED"),
		MaxResults:      tea.Int32(10),
		NextToken:       tea.String("0"),
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
		res, _err := client.SdkClient.ListEventSources(request)
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
