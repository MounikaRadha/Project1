package main

import "fmt"
import "io"
import "path/filepath"
import "os"
import "sync"
import "time"

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
	for _, item := range items {
		var newWg sync.WaitGroup
		newWg.Add(1)
		var path1 string = dirName + fileSep + item.Name()
		if item.IsDir() {
			copyDir(path1, &newWg)
			newWg.Wait()
			continue
		}
		copyMyFile(destFolder+path1, path1, &newWg)

	}

}
func callCopyDirByCmd() {
	if len(os.Args) != 2 {
		return
	}
	var dirName = os.Args[1]
	var wg sync.WaitGroup
	wg.Add(1)
	copyDir(dirName, &wg)
	wg.Wait()
	fmt.Print("\nin copy go file")
}

func main() {
	t1 := time.Now()
	callCopyDirByCmd()
	t2 := time.Now()
	fmt.Printf("the time it took is %v",t2.Sub(t1))

}
