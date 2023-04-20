<template>
<div v-if="$store.state.sharingItem.outfitId == outfitId">
  <form ref="form" @submit.prevent="sendEmail">
    <label>Email</label>
    <input v-model="user_email" type="email" name="to_email" />
    <i
        class="fa fa-envelope-o"
        title="Send"
        style="font-size: 24px"
        v-on:click.prevent="sendEmail"
      ></i>
  </form>
  </div>
</template>

<script>
import emailjs from "@emailjs/browser";

export default {
  data() {
    return {
      user_email: ''
    }
  },
  props: ["outfitId", "canvasDataUrl"],
  methods: {
    sendEmail() {
      emailjs
        .send("digital_closet19", "template_etxx6g9", {
          user_name: "user",
          to_email: this.user_email,
          id: this.outfitId,
          imgUrl: this.canvasDataUrl
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