<template>
  <div id="main">
    <div id="clothing-items" v-for="type in types" v-bind:key="type.id">
      <p id="type">Choose your {{ type }}:</p>
      <div id="image-container">
        <img v-on:click="makeSelection(cloth)" v-for="cloth in filterByType(type)" v-bind:key="cloth.id" v-bind:src="cloth.imgUrl"
        />
      </div>
    </div>
  </div>
</template>

<script>
import ClosetService from "@/services/ClosetService";
export default {
  data() {
    return {
      types: [],
      clothing: [],
      selectedItem: [],
    };
  },
 
  methods: {
    getClothesList() {
      ClosetService.getClothingList()
        .then((response) => {
          this.clothing = response.data;
        })
        .catch((err) => {
          console.error(err);
        });
    },
    filterByType(type) {
      return this.clothing.filter((cloth) => {
        return cloth.type === type;
      });
    },
    filterForItem(cloth) {
      if (this.selectedItem.includes(cloth)) {
        this.selectedItem = this.selectedItem.filter((item) => {
          return item.id != cloth.id;
        });
      } else {
        this.selectedItem = this.selectedItem.filter((item) => {
          return item.type != cloth.type;
        });
        this.selectedItem.unshift(
          this.clothing.find((item) => {
            return item.id === cloth.id;
          })
        );
      }
    },
    makeSelection(cloth) {
      if (this.$store.state.selectedItems.includes(cloth)) {
        this.$store.commit("DESELECT_ITEM", cloth);
      } else {
        this.$store.commit("SELECT_ITEM", cloth);
      }
    },
    isTypeSelection(type) {
        this.$store.state.selectedItems.forEach( item => {
            if(item.type === type) {
                return true;
            } 
        });
        return false;
    }
  },
  created() {
    ClosetService.getTypes()
      .then((response) => {
        this.types = response.data;
      })
      .catch((err) => console.error(err));
    this.getClothesList();
  },
};
</script>

<style scoped>
#main,
#image-container,
#clothing-items {
  display: flex;
}

#main {
  flex-direction: column;
}
#type {
}
#image-container {
  flex-direction: row;
}
#clothing-items {
  flex-direction: column;
}
div img {
  height: auto;
  width: 100px;
}
</style>