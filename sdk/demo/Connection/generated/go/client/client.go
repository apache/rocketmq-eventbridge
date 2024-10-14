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
// test func for Connection Controller apis:
//
// createConnection    *
//
// deleteConnection    *
//
// updateConnection    *
//
// getConnection       *
//
// selectOneConnection *
//
// listConnections     *
//
// listEnumsResponse   *
func (client *DemoClient) TestCreateConnection() (_err error) {
	request := &sdkclient.CreateConnectionRequest{
		ConnectionName: tea.String("new-connection"),
		NetworkParameters: &sdkclient.CreateConnectionRequestNetworkParameters{
			NetworkType: tea.String("PublicNetwork"),
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
		res, _err := client.SdkClient.CreateConnection(request)
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

func (client *DemoClient) TestDeleteConnection() (_err error) {
	request := &sdkclient.DeleteConnectionRequest{
		ConnectionName: tea.String("new-connection"),
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
		res, _err := client.SdkClient.DeleteConnection(request)
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

func (client *DemoClient) TestUpdateConnection() (_err error) {
	request := &sdkclient.UpdateConnectionRequest{
		ConnectionName: tea.String("new-connection"),
		NetworkParameters: &sdkclient.UpdateConnectionRequestNetworkParameters{
			NetworkType:     tea.String("PrivateNetwork"),
			SecurityGroupId: tea.String("eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb"),
			VpcId:           tea.String("eb-test/vpc-bp1symadadwnwgmqud"),
			VswitcheId:      tea.String("vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c"),
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
		res, _err := client.SdkClient.UpdateConnection(request)
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

func (client *DemoClient) TestGetConnections() (_err error) {
	request := &sdkclient.GetConnectionRequest{
		ConnectionName: tea.String("new-connection"),
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
		res, _err := client.SdkClient.GetConnection(request)
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

func (client *DemoClient) TestSelectOneConnection() (_err error) {
	request := &sdkclient.GetConnectionRequest{
		ConnectionName: tea.String("new-connection"),
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
		res, _err := client.SdkClient.SelectOneConnection(request)
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

func (client *DemoClient) TestListConnections() (_err error) {
	request := &sdkclient.ListConnectionsRequest{
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
		res, _err := client.SdkClient.ListConnections(request)
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

func (client *DemoClient) TestListEnumsResponse() (_err error) {
	defer func() {
		console.Log(tea.String("test end!"))
	}()
	tryErr := func() (_e error) {
		defer func() {
			if r := tea.Recover(recover()); r != nil {
				_e = r
			}
		}()
		res, _err := client.SdkClient.ListEnumsResponse()
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
