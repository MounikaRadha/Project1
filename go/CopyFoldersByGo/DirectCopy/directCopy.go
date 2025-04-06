package main
import "os"
import "fmt"
import "time"
func main(){
	t1 := time.Now()
	directCopy()
	t2 := time.Now()
	fmt.Printf("the time it took is %v",t2.Sub(t1))
	
}
func directCopy(){
	if len(os.Args) != 2 {
		fmt.Println("please provide a argument which is the directory to copy ")
		return
	}
	os.CopyFS("destNew",os.DirFS(os.Args[1]))
}