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
// ApiDestination Controller apis:
//
// createApiDestination *
//
// updateApiDestination *
//
// getApiDestination    *
//
// deleteApiDestination *
//
// listApiDestinations  *
func (client *DemoClient) TestCreateApiDestination() (_err error) {
	request := &sdkclient.CreateApiDestinationRequest{
		ApiDestinationName: tea.String("new-api-destination"),
		ConnectionName:     tea.String("new-connection"),
		Description:        tea.String("demo api destination for test"),
		HttpApiParameters: &sdkclient.CreateApiDestinationRequestHttpApiParameters{
			Endpoint: client.Endpoint,
			Method:   tea.String("POST"),
		},
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
		res, _err := client.SdkClient.CreateApiDestination(request)
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

func (client *DemoClient) TestUpdateApiDestination() (_err error) {
	request := &sdkclient.UpdateApiDestinationRequest{
		ApiDestinationName: tea.String("new-api-destination"),
		ConnectionName:     tea.String("new-connection"),
		Description:        tea.String("!updated! demo api destination for test"),
		HttpApiParameters: &sdkclient.UpdateApiDestinationRequestHttpApiParameters{
			Endpoint: client.Endpoint,
			Method:   tea.String("GET"),
		},
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
		res, _err := client.SdkClient.UpdateApiDestination(request)
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

func (client *DemoClient) TestGetApiDestination() (_err error) {
	request := &sdkclient.GetApiDestinationRequest{
		ApiDestinationName: tea.String("new-api-destination"),
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
		res, _err := client.SdkClient.GetApiDestination(request)
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

func (client *DemoClient) TestDeleteApiDestination() (_err error) {
	request := &sdkclient.DeleteApiDestinationRequest{
		ApiDestinationName: tea.String("new-api-destination"),
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
		res, _err := client.SdkClient.DeleteApiDestination(request)
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

func (client *DemoClient) TestListApiDestinations() (_err error) {
	request := &sdkclient.ListApiDestinationsRequest{
		MaxResults: tea.Int32(2),
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
		res, _err := client.SdkClient.ListApiDestinations(request)
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
