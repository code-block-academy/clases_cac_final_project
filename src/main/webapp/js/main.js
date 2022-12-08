//fetch("demo?id=1").then((e) => console.log(e));
//.then((res) => res.json())
//fetch("CommentsByIdProduct?id=13")
//        .then((response) => response.json())
//        .then((json) => console.log(json));
//
fetch("allproducts")
        .then((response) => response.json())
        .then((json) => console.log(json));
//fetch("CleanDemo")
//        .then((response) => response.json())
//        .then((json) => console.log(json));
