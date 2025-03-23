import NoDataInDb from "../NoDataInDb";
const PostedDataListViewComponent = ({ postedDataList = [] }) => {
  if (postedDataList.length > 0)
    return postedDataList?.map((item) => (
      <PostedDataItem postedDataItem={item} />
    ));
  else return <NoDataInDb modalType={"Posted Data"} />;
};

export const PostedDataItem = ({ postedDataItem }) => {
  return (
    <>
      <p>postId:{postedDataItem?.["postId"]}</p>
      <p>endpoint:{postedDataItem?.["endPoint"]["endPoint"]}</p>
      <p>postData:{postedDataItem?.["postData"]}</p>
      <p>tags:{postedDataItem?.["tags"]}</p>
    </>
  );
};
export default PostedDataListViewComponent;
