import NoDataInDb from "../NoDataInDb";
import "../../styles/ListViewComponent.css";

const PostedDataListViewComponent = ({ postedDataList = [] }) => {
  if (postedDataList.length > 0)
    return (
      <div className="my-list-container">
        {postedDataList.map((item) => (
          <PostedDataItem key={item.postId} postedDataItem={item} />
        ))}
      </div>
    );
  else return <NoDataInDb modalType={"Posted Data"} />;
};

export default PostedDataListViewComponent;

export const PostedDataItem = ({ postedDataItem }) => {
  return (
    <div className="my-card">
      {postedDataItem?.postId && (
        <p className="my-label">
          <span className="label">Post ID:</span> {postedDataItem.postId}
        </p>
      )}
      {postedDataItem?.endPoint?.endPoint && (
        <p className="my-label">
          <span className="label">Endpoint:</span> {postedDataItem.endPoint.endPoint}
        </p>
      )}
      {postedDataItem?.postData && (
        <p className="my-label">
          <span className="label">Post Data:</span> {postedDataItem.postData}
        </p>
      )}
      {postedDataItem?.tags && (
        <p className="my-label">
          <span className="label">Tags:</span> {postedDataItem.tags}
        </p>
      )}
    </div>
  );
};
