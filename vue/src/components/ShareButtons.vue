<template>
  <div v-if="$store.state.sharingItem.outfitId == outfitId">
      
      <ShareNetwork
        network="pinterest"
        :url="imgUrl"
        title="Look at my Foxtrot Closet outfit!"
      > <i class="fa fa-pinterest" style="font-size:48px;color:red"></i>
      </ShareNetwork>
  </div>
</template>

<script>
export default {
  props: ['imgUrl', 'outfitId']
};
</script>

<style>
a.share-network-pinterest{
  text-decoration: none;
}
</style>