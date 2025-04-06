package main

import "fmt"
import "io"
import "path/filepath"
import "os"
import "strconv"
import "sync"

var dirName = "dir1"
var fileSep = "/"
var destFolder = "dest/"

func handleErr(err error) {
	if err != nil {
		fmt.Print("err came" + err.Error())
	}
}

func copyMyFile(destPath, srcPath string, wg *sync.WaitGroup) {
	defer wg.Done()
	err := os.MkdirAll(filepath.Dir(destPath), 0777)
	handleErr(err)
	var source, err1 = os.Open(srcPath)
	handleErr(err1)
	var destination, err2 = os.Create(destPath)
	handleErr(err2)
	io.Copy(destination, source)
}

func copyDir(dirName string, wg *sync.WaitGroup) {
	defer wg.Done()
	var items, err = os.ReadDir(dirName)
	handleErr(err)
	for index, item := range items {
		fmt.Printf("in the for loop of " + dirName + strconv.Itoa(index))
		var newWg sync.WaitGroup
		newWg.Add(1)
		var path1 string = dirName + fileSep + item.Name()
		if item.IsDir() {
			copyDir(path1, &newWg)
			newWg.Wait()
			return
		}
		copyMyFile(destFolder+path1, path1, &newWg)

	}

}

func main() {
	var wg sync.WaitGroup
	wg.Add(1)
	copyDir("Dir1", &wg)
	wg.Wait()
	fmt.Print("\nin copy go file")
}
