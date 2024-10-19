package main

import (
	"client/client"
)

func main() {
	demo := new(client.DemoClient)
	demo.Init()
	demo.TestCreateEventSource()
}
