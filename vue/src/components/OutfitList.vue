<template>
  <div id="whole-component">
    <div id="page-header">
      <h1>My Outfits</h1>
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
              :width="1200"
              :height="getHeight(outfit)"
              style="border: 1px solid #d3d3d3"
            >
              Your browser does not support the HTML canvas tag.</canvas
            >
            <div v-for="item in outfit.itemList" v-bind:key="item.id">
              <img
                :id="getImageId(outfit.outfitId, item.type)"
                v-bind:src="item.imgUrl"
                crossorigin="anonymous"
              />
            </div>

            <button @click.prevent="getDataUrl(outfit)">
              Share This Outfit!
            </button>
            <ShareButtons v-if="sharingOutfit" :outfitId="outfit.outfitId" />
            <SendEmail
              v-if="sharingOutfit"
              :outfitId="outfit.outfitId"
              :canvasDataUrl="canvasDataUrl"
            />
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
      canvasDataUrl: "",
      sharingOutfit: false,
    };
  },
  computed: {
    validOutfits() {
      return this.outfits.filter((outfit) => {
        return outfit.itemList.length > 1;
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
    getHeight(outfit) {
      return outfit.itemList.length < 4 ? 800 : 1600;
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
          console.log(outfit.outfitId + " John Said " + type);
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
        let x = 0;
        let y = 0;
        let count = 0;
        this.types.forEach((type) => {
          console.log("for each type");
          console.log(this.outfitContainsType(outfit, type));
          if (this.outfitContainsType(outfit, type)) {
            let imgId = this.getImageId(outfit.outfitId, type);
            console.log("drawing " + imgId);
            let img = document.getElementById(imgId);
            console.log(img);

            if (count == 1) {
              x = 600;
            }
            if (count == 2) {
              x = 0;
              y = 800;
            }
            if (count == 3) {
              x = 600;
              y = 800;
            }

            ctx.drawImage(img, x, y, 600, 800);
            count++;
          }
        });
      });
    },
    getDataUrl(outfit) {
      this.sharingOutfit = true;
      let canvas = document.getElementById(this.getCanvasId(outfit.outfitId));
      this.canvasDataUrl = canvas.toDataURL("image/jpeg", 0.1);
      console.log(this.canvasDataUrl);
      
    },
  },
  created() {
    this.getAllOutfits();

    this.refreshCloset;
    ClosetService.getTypes()
      .then((response) => {
        this.types = response.data;
        this.drawItemsToCanvas();
      })
      .catch((err) => console.error(err));
  },
  mounted() {
    this.drawItemsToCanvas();
  },
};
</script>

<style scoped>
#whole-component {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
canvas {
  width: 50vw;
}
img {
  margin: 3px;
  display: none;
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