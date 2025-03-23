const PostedDataListViewComponent=({postedDataList=[]})=>{
    if(postedDataList.length>0)
        return postedDataList?.map((item) => <PostedDataItem postedDataItem={item}/>);
        else return <p>no posted data for now</p>
}

const PostedDataItem=({postedDataItem})=>{
return <>
<p>{postedDataItem?.["postedId"]}</p>
<p>{postedDataItem?.["endPoint"]["endPoint"]}</p>
<p>{postedDataItem?.["postData"]}</p>
<p>{postedDataItem?.["tags"]}</p>
</>
}
export default PostedDataListViewComponent;