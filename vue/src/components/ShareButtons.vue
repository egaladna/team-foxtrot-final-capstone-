<template>
  <div>
    <button>
      <ShareNetwork
        network="facebook"
        url="www.pinterest.com"
        title="Look at my Foxtrot Closet outfit!"
      >
        Facebook
      </ShareNetwork>
    </button>
    <button>
      <ShareNetwork
        network="twitter"
        url="http://localhost:8080/myoutfits/"
        title="Look at my Foxtrot Closet outfit!"
      >
        Twitter
      </ShareNetwork>
    </button>

    <button>
      <ShareNetwork
        network="pinterest"
        url="http://localhost:8080/myoutfits/"
        title="Look at my Foxtrot Closet outfit!"
      >
        Pinterest
      </ShareNetwork>
    </button>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>