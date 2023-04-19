<template>
  <div id="whole-component">
    <div id="page-header">
      <h1>My Outfits</h1>

      <button @click="drawItemsToCanvas">Draw Items</button>
      <ShareButtons />
      <SendEmail />


    </div>
    <div class="all-outfits">
      <div v-for="outfit in validOutfits" v-bind:key="outfit.id">
        <div
          v-bind:to="{
            name: 'outfit-detail',
            params: {
              id: outfit.outfitId,
            },
          }"
        >
          <div class="outfit-container">
            <canvas
              :id="getCanvasId(outfit.outfitId)"
              width="500"
              height="300"
              style="border: 1px solid #d3d3d3"
            >
              Your browser does not support the HTML canvas tag.</canvas
            >
            <div v-for="item in outfit.itemList" v-bind:key="item.id">
              <img
                :id="getImageId(outfit.outfitId, item.type)"
                v-bind:src="item.imgUrl"
              />
            </div>
            <ShareButtons :outfitId="outfit.outfitId" />
            <SendEmail :outfitId="outfit.outfitId"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import OutfitService from "../services/OutfitService";
import ShareButtons from "../components/ShareButtons";
import SendEmail from "../components/SendEmail";
import ClosetService from "@/services/ClosetService";

export default {
  components: {
    ShareButtons,
    SendEmail,
  },
  data() {
    return {
      outfits: [],
      types: [],
    };
  },
  computed: {
    validOutfits() {
      return this.outfits.filter((outfit) => {
        return outfit.itemList.length > 0;
      });
    },
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
    getCanvasId(outfitId) {
      return outfitId + "outfitCanvas";
    },
    getImageId(outfitId, type) {
      return outfitId + type + "image";
    },
    outfitContainsType(outfit, type) {
      let containsType = false;
      outfit.itemList.forEach((item) => {
        if (item.type == type) {
          console.log(outfit.outfitId + " John Said " + type)
          containsType = true;
        }
      });
      return containsType;
    },
    drawItemsToCanvas() {
      console.log("in drawing method");
      this.validOutfits.forEach((outfit) => {
        let c = document.getElementById(this.getCanvasId(outfit.outfitId));
        console.log(this.getCanvasId(outfit.outfitId));
        let ctx = c.getContext("2d");
        let x = 5;
        let y = 5;
        this.types.forEach((type) => {
          console.log("for each type");
          console.log(this.outfitContainsType(outfit, type));
          if (this.outfitContainsType(outfit, type)) {
            let imgId = this.getImageId(outfit.outfitId, type);
            console.log("drawing " + imgId);
            let img = document.getElementById(imgId);
            console.log(img);
            ctx.drawImage(img, x, y, 80, 80);
            x += 80;
            y += 10;
          }
        });
      });
    },
  },
  created() {
    this.getAllOutfits();

    this.refreshCloset;
    ClosetService.getTypes()
      .then((response) => {
        this.types = response.data;
      })
      .catch((err) => console.error(err));
  },
  beforeMount() {
    this.drawItemsToCanvas();
  }
};
</script>

<style scoped>
#whole-component {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
img {
  margin: 3px;
  display:none;
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