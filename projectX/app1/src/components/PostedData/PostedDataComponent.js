import PostedDataCreationComponent from "./PostedDataCreationComponent";
import PostedDataListViewComponent from "./PostedDataListViewComponent";
import PostedDataService from "./PostedDataService";

const PostedDataComponent=()=>{
    const postedData=PostedDataService.useFindAllPostedData();
    return(<>
    <p>posted data Component</p>
    <PostedDataListViewComponent postedDataList={postedData}/>
    <PostedDataCreationComponent/>
    </>)
}
export default PostedDataComponent;