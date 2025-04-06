package main
import "fmt"
import "sync"
func printHi(wg *sync.WaitGroup){
	defer wg.Done()
	fmt.Print("hi from printt \n")
}
func main(){
	var wg sync.WaitGroup
	wg.Add(1)
	go printHi(&wg)
	wg.Wait()
fmt.Print("in main func of go routine test")
}