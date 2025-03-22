const UsersListViewComponent=({usersList=[]})=>{
    if(usersList.length>0)
    return usersList?.map((x) => <p>{x["username"]}</p>);
    else return <p>no usrs for now</p>
}
export default UsersListViewComponent;