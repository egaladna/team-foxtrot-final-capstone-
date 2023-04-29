<template>
  <div class="view-frame">
    <div class="home-container">
      <h1>Hello!</h1>
      <div class="box">
        <h2>Introducing our Foxtrot Closet Service</h2>
        <p>
          With our service, you can easily organize your wardrobe online, and
          never forget what you have again!
        </p>
        <p>Our service allows you to:</p>
        <ul>
          <li>Upload photos of your clothes</li>
          <li>Organize your items by category, color, or occassion</li>
          <li>Create outfits and see how they look before you wear them</li>
          <li>And much more!</li>
        </ul>
      </div>
      <div class="box">
        <h2>How our Foxtrot Closet Service Works</h2>
        <p>Using our service is easy:</p>
        <ol>
          <li>Sign up for an account on our website</li>
          <li>Take photos of your clothes and upload them to your account</li>
          <li>Organize your clothes by category, color, or occassion</li>
          <li>Create outfits by combining items from your wardrobe</li>
          <li>Save and share your favorite outfits with friends</li>
        </ol>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style scoped>


.view-frame {
  display: flex;
  padding-top: 50vh;
  justify-content: center;
}
body,
html {
  margin: 0;
  padding: 0;
}

/* Set font styles */
body {
  display: flex;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.5;
  color: #333;
  background-color: transparent;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  display: flex;
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-weight: 500;
  color: #333;
  margin-top: 0;
  margin-bottom: 10px;
}

h1 {
  text-align: center;
}

p {
  margin-top: 0;
  margin-bottom: 1rem;
}


.home-container {
  max-width: 600px;
  margin-bottom: 10px;
  margin-top: -200px;
  padding: 5px;
  background-color: transparent;
  border: 2px solid black;
  border-radius: 5px;
  box-shadow: -10px -15px 10px black;
}


.box {
  margin: 20px;
  padding: 20px;
  background-color: rgb(247, 234, 191);
  border: 1px solid #ccc;
  box-shadow: 5px 5px 5px black;
  border-radius: 5px;
  float: left;
  width: calc(50% - 40px);
  box-sizing: border-box;
}

.box h2 {
  margin-top: 0;
}
</style>


