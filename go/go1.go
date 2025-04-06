package main

import (
	"fmt"
	"io"
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
func copyFiles(destPath,srcPath string){
	var source,err1 =os.Open(srcPath)
	handleErr(err1)
	var destination,err2=os.Create(destPath)
	handleErr(err2)
	io.Copy(destination,source)
}
func invokeCopy(){
	var sourcePath string=dirName+fileSep+"myFile0.txt"
	var destPath string=dirName+fileSep+"newOne.txt"
	copyFiles(destPath,sourcePath)
}
func main() {
	// createDummyFiles(5)
	// writeToFiles()
	invokeCopy()
	fmt.Print("hello go")
}
