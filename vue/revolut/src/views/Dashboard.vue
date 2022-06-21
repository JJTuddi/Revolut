<template>
  <div class="container">
    <div class="drawer" style="background-color: #C6C6C6">
      <div class="drawer-content">
        <div>
          <img
              :src="imageLink"
              style="border-radius: 50%; width: 10vw; height: 10vw"
          />
        </div>
        <div> {{ details.firstName }}, {{ details.lastName }}</div>
        <div> {{ details.email }}</div>
        <v-divider></v-divider>
        <div style="margin: 5px">
          <v-btn
              :block="true"
              @click="changeViewToCards"
          > Cards
          </v-btn>
        </div>
        <div style="margin: 5px">
          <v-btn
              @click="changeViewToTransfers"
          > Transfers
          </v-btn>
        </div>
        <div style="margin: 5px">
          <v-btn
              @click="changeViewToDeposits"
          > Deposits
          </v-btn>
        </div>
        <div style="margin: 5px">
          <v-btn
              @click="changeViewToContacts"
          > Contacts
          </v-btn>
        </div>
      </div>
    </div>
    <div class="content" style="background-color: #E7E7E7">
      <div
          style="margin: 20px"
      >
        <v-card v-if="view === 'cards'">
          <v-card-title> Cards</v-card-title>
          <v-card-content>
            <v-card
                class="ma-2"
                v-for="card in cards"
                :key="card.number"
            >
              <v-card-title> Card Number: {{ card.number.match(/.{4}/g).join("-") }}</v-card-title>
              <v-container>
                <v-row>
                  <v-col>
                    <div
                        :style="{ backgroundColor: card.cardType.color, width: '200px', height: '100%'}"
                        style="display: flex; justify-content: center; align-items: center"
                    >
                      <div>
                        {{ card.cardType.name }}
                      </div>
                    </div>
                  </v-col>
                  <v-col>
                    <p><strong> CVV: </strong> {{ card.cvv }} </p>
                    <p><strong> Expiration Date: </strong> {{ card.expirationDate }} </p>
                    <p><strong> CurrentAmount: </strong> {{ card.currentAmount }} {{ getCurrencyFromIban(card.iban) }}
                    </p>
                    <p><strong> IBAN: </strong> {{ card.iban }} </p>
                  </v-col>
                </v-row>
              </v-container>
            </v-card>
          </v-card-content>
          <v-container>
            <v-row>
              <v-spacer/>
              <v-select
                  filled
                  v-model="selectedReportType"
                  label="Report Type"
                  :items="reportTypes"
              ></v-select>
              <v-btn
                  style="background-color: var(--primary); color: white"
                  @click="saveCardsReport"
              >
                Download Cards Report
              </v-btn>
            </v-row>
          </v-container>
        </v-card>
        <v-card v-if="view === 'contacts'">
          <v-card-title> Contacts</v-card-title>
          <v-card-content>

          </v-card-content>
        </v-card>
        <v-card v-if="view === 'deposits'">
          <v-card-title>
            Deposits
          </v-card-title>
          <v-card-content>
            <v-container>
              <v-row>
                <v-card></v-card>
              </v-row>
            </v-container>
          </v-card-content>
        </v-card>
        <v-card v-if="view === 'transfers'">
          <v-card-title> Transfers</v-card-title>
          <v-card-content>

          </v-card-content>
        </v-card>
      </div>
    </div>
  </div>
</template>

<script>
import AuthService from "@/service/AuthService";
import CardsService from "@/service/CardsService";
import ReportsService from "@/service/ReportsService";

export default {
  name: "Dashboard",
  data() {
    return {
      drawer: false,
      view: "cards",
      details: {},
      cards: {},
      reportTypes: [
        "CSV", "PDF"
      ],
      selectedReportType: "",
    }
  },

  computed: {

    imageLink() {
      return 'http://localhost:3077/images/' + this.details.profileImageName;
    }

  },

  methods: {
    changeViewToCards() {
      this.view = 'cards';
      CardsService.getCards()
          .then(response => {
            this.cards = response;
            console.log(response)
          });
    },

    changeViewToTransfers() {
      this.view = 'transfers'
    },

    changeViewToDeposits() {
      this.view = 'deposits'
    },

    changeViewToContacts() {
      this.view = 'contacts';
    },

    getCurrencyFromIban(iban) {
      return iban.match(/BTR(.*)RCRT/g)[0].replace("BTR", "").replace("RCRT", "");
    },

    saveCardsReport() {
      ReportsService.getCardsReport(this.selectedReportType);
    }

  },

  mounted() {
    console.log("intra si pa aci")
    AuthService.getDetails()
        .then(response => this.details = response)
        .catch(() => this.$router.push('/'));
    this.changeViewToCards();
  }

}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

.drawer-content {
  width: 100%;
  height: 100%;
  display: none;
}

.drawer {
  width: 1vw;
  height: 100vh;
}

.drawer:hover {
  width: 20vw;
  transition: width 0.3s;
  transition-timing-function: ease-in-out;
}

.content {
  width: 99vw;
  height: 100vh;
  overflow: scroll;
  overflow-x: hidden;
}

.drawer:hover .content {
  width: 80vw;
}

.drawer:hover .drawer-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow-x: hidden;
  overflow-y: scroll;
}

</style>