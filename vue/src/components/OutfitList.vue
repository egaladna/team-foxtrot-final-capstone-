<template>
  <div id="whole-component">
    <div id="page-header">
      <h1>My Outfits</h1>
      <ShareButtons />
      <SendEmail />
    </div>
    <div class="all-outfits">
      <div v-for="outfit in validOutfits" v-bind:key="outfit.id">
        <router-link
          v-bind:to="{
            name: 'outfit-detail',
            params: {
              id: outfit.outfitId,
            },
          }"
        >
          <div class="outfit-container">
            <div v-for="item in outfit.itemList" v-bind:key="item.id">
              <img v-bind:src="item.imgUrl" />
            </div>
          </div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import OutfitService from "../services/OutfitService";
import ShareButtons from "../components/ShareButtons";
import SendEmail from "../components/SendEmail";

export default {
  data() {
    return {
      outfits: [],
    };
  },
  computed: {
    validOutfits() {
      return this.outfits.filter((outfit) => {
        return outfit.itemList.length > 0;
      });
    },
  },
  components: {
    ShareButtons,
    SendEmail,
  },
  methods: {
    getAllOutfits() {
      OutfitService.getOutfits()
        .then((response) => {
          if (response.status === 200) {
            this.outfits = response.data;
          }
        })
        .catch((err) => console.error(err));
    },
  },
  created() {
    this.getAllOutfits();
  },
};
</script>

<style>
#whole-component {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
img {
  margin: 3px;
}
.outfit-container {
  margin: 20px;
  padding: 20px;
  display: flex;
  border: solid #1b3536;
  border-radius: 8px;
  width: fit-content;
  block-size: fit-content;
  display: flex;
  flex-wrap: wrap;
}
.all-outfits {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
#page-header {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
}
</style>