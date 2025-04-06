package main

import (
	"fmt"
	"os"
	"strconv"
)

var dirName string = "dir1"
var fileSep string = "/"
var dummyFilePrefix string = "myFile"

func handleErr(err error) {
	if err != nil {
		fmt.Print("err came" + err.Error())
	}
}
func createDummyFiles(count int) {
	for index := range count {
		var _, err = os.OpenFile(dirName+fileSep+dummyFilePrefix+strconv.Itoa(index)+".txt", os.O_CREATE, 0777)
		handleErr(err)
	}
}
func writeToFiles() {
	var dirs, _ = os.ReadDir(dirName)
	for index, name := range dirs {
		var file, err = os.OpenFile(dirName+fileSep+name.Name(), os.O_CREATE|os.O_APPEND|os.O_WRONLY, 0777)
		handleErr(err)
		var _, err2 = file.WriteString("written from file the index is " + strconv.Itoa(index))
		handleErr(err2)
		defer file.Close()
	}
}
func main() {
	createDummyFiles(5)
	writeToFiles()
	fmt.Print("hello go")
}
