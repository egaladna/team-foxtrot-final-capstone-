<template>
  <form ref="form" @submit.prevent="sendEmail">
    <label>Name</label>
    <input type="text" name="user_name" />
    <label>Email</label>
    <input type="email" name="to_email" />
    <input type="submit" value="Send" />
  </form>
</template>

<script>
import emailjs from "@emailjs/browser";

export default {
  props: ["outfitId"],
  methods: {
    sendEmail() {
      emailjs
        .send("digital_closet19", "template_etxx6g9", {
          user_name: "tommy pickles",
          to_email: "foxtrotclosette@gmail.com",
          id: this.outfitId
        }, "7ZUF6vM1us8CHgfYg")
        .then(
          (result) => {
            console.log("SUCCESS!", result.text);
          },
          (error) => {
            console.log("FAILED...", error.text);
          }
        );
    },
  },
};
</script>