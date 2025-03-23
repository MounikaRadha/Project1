import PostedDataCreationComponent from "./PostedDataCreationComponent";
import PostedDataListViewComponent from "./PostedDataListViewComponent";
import PostedDataService from "./PostedDataService";
import "../../styles/Common.css";

const PostedDataComponent = () => {
  const postedData = PostedDataService.useFindAllPostedData();
  return (
    <div className="my-container">
      <div className="creation-section">
        <PostedDataCreationComponent />
      </div>
      <div className="list-section">
        <PostedDataListViewComponent postedDataList={postedData} />\
      </div>
    </div>
  );
};
export default PostedDataComponent;
