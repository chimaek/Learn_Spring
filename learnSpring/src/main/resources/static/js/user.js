let index = {
  init: function () {
    $("#btn-save").on("click", () => {
      this.save();
    });
  },

  save: function () {
    // alert("클릭됨");
    let data = {
      username: $("#username").val(),
      password: $("#password").val(),
      email: $("#email").val(),
    };
    data = JSON.stringify(data);
    console.log(data);
    axios
      .post("/blog/api/user", data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        console.log(response);
        location.
      });
  },
};
index.init();
