import NoDataInDb from '../NoDataInDb'

const EndPointListViewComponent = ({ endPointsList = [] }) => {
  return (
    <>
      endpoint list view component
      {endPointsList.length > 0 ? (
        endPointsList?.map((endpoint) => <EndPointItem endPointItem={endpoint}/>)
      ) : (
        <NoDataInDb modalType={"End poin"}/>
      )}
    </>
  );
};
export default EndPointListViewComponent;

export const EndPointItem=({endPointItem})=>{
  return (<>
  <p>endpoint:{endPointItem?.["endPoint"]}</p>
  </>)
}