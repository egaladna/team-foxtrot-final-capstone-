<template>
  <div id = "main">
    <div id="clothing-items" v-for="type in types" v-bind:key="type.id">
        <SelectedItems v-bind:type="type" v-bind:item="selectedItem"/>
      <p id = "type" >Choose your {{ type }}:</p>
      <div id = "image-container">
          <img v-on:click="filterForItem(cloth)" v-for="cloth in filterByType(type)" v-bind:key="cloth.id" v-bind:src="cloth.imgUrl"/>
      </div>
    </div>
  </div>
</template>

<script>
import ClosetService from "@/services/ClosetService";
import SelectedItems from '@/components/SelectedItems';
export default {
  data() {
    return {
      types: [],
      clothing: [],
      selectedItem:[]
    };
  },
  components: {
      SelectedItems
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
        this.selectedItem = this.selectedItem.filter( (item) => {
            return item.type != cloth.type;
        });
        this.selectedItem.unshift(this.clothing.find((item) => {
            return item.id === cloth.id;
        }));
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