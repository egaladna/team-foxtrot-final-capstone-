<template>
  <div class="view-frame">
    <ClothesList />
    <UploadFile />
  </div>
</template>

<script>
import ClothesList from "@/components/ClothesList.vue"
import UploadFile from "@/components/UploadFile.vue"

export default {
    components: {
        ClothesList,
        UploadFile
    }
}
</script>

<style>

</style>