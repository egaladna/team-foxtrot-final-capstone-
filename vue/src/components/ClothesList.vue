<template>
  <div>
      <div v-for='cloth in clothing' v-bind:key='cloth.id'>
          <ClothingItem v-bind:cloth ='cloth' />
      </div>
  </div>
</template>

<script>
import ClothingItem from '@/components/ClothingItem'
import ClosetService from '@/services/ClosetService'


export default {
    data() {
        return {
            clothing: []
        }
    },
    components: {
        ClothingItem,
    },

    created() {
        ClosetService.getClothingList().then(response => {
            this.clothing = response.data;
        }).catch(err => {
            console.error(err);
        });
    }
}
</script>

<style>

</style>